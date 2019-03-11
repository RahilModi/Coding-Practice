package com.programming.leetcode.Medium;

import java.util.*;

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


    public int leastIntervalV1(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        System.out.println(new TaskScheduler().leastIntervalV1(new char[]{'A','B','A','B','A','B','C','D'},2));
    }
}
