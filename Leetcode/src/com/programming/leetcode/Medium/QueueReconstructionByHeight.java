package com.programming.leetcode.Medium;

import java.util.*;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)-> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);

        List<int[]> queue = new ArrayList<>();
        for(int[] person : people){
            queue.add(person[1], person);
        }
        return queue.toArray(new int[queue.size()][2]);
    }


    public int[][] reconstructQueueUsingPriorityQueue(int[][] people) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);
        for(int[] person : people){
            pq.offer(person);
        }
        List<int[]> queue = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] person = pq.poll();
            queue.add(person[1], person);
        }
        return queue.toArray(new int[queue.size()][2]);
    }


    public static void main(String[] args) {
       int[][] queue = new QueueReconstructionByHeight().reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
       for(int[] person : queue) System.out.println(person[0]+ ", "+person[1]);

    }
}
