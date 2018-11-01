package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        int[] charMap = new int[26];
        for(char c : tasks){
            charMap[c-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());
        for(int i: charMap){
            if(i>0) pq.offer(i);
        }

        int intervals = 0;
        while(!pq.isEmpty()){
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while(i <= n){
                if(!pq.isEmpty()) {
                    int val = pq.poll();
                    if (val > 1) {
                        temp.add(val - 1);
                    }
                }
                intervals++;
                i++;
                if(pq.isEmpty() && temp.size() == 0) break;
            }
            for(int j : temp){
                pq.offer(j);
            }
        }

        return intervals;

    }

    public static void main(String[] args) {
        System.out.println(new TaskScheduler().leastInterval(new char[]{'A','B','A','B','A','B'},2));
    }
}
