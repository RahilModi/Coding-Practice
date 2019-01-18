package com.programming.leetcode.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> q = null;
    int window = 3000;
    public RecentCounter() {
        q = new LinkedList();
    }

    public RecentCounter(int window_time){
        this.window = window_time;
    }

    public int ping(int t) {
        q.add(t);
        while(q.peek() < (t - window)){
            q.poll();
        }
        return q.size();
    }

    public static void main(String[] args) {
        RecentCounter cnt = new RecentCounter();
        System.out.println(cnt.ping(1));
        System.out.println(cnt.ping(2));
        System.out.println(cnt.ping(100));
        System.out.println(cnt.ping(3001));
        System.out.println(cnt.ping(3002));
    }
}
