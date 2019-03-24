package com.programming.leetcode.Hard;

import java.util.PriorityQueue;

public class IPO {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        for(int i = 0; i < Capital.length; i++){
            pq.offer(new int[]{Capital[i], Profits[i]});
        }

        PriorityQueue<Integer> possibleProjects = new PriorityQueue<>((a,b)->b-a);

        while (k-- > 0){
            while (!pq.isEmpty() && pq.peek()[0] <= W){
                possibleProjects.offer(pq.poll()[1]);
            }

            if(possibleProjects.isEmpty()) break;

            W += possibleProjects.poll();
        }
        return W;
    }

    public static void main(String[] args) {
        IPO obj = new IPO();
        System.out.println(obj.findMaximizedCapital(2,0,new int[]{1,2,3},new int[]{0,1,1}));
    }
}
