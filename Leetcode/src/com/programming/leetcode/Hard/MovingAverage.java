package com.programming.leetcode.Hard;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    int windowSize = 1;
    public MovingAverage(int win_size) {
        this.windowSize = win_size;
    }

    Queue<Integer> queue = new LinkedList<>();
    double sum = 0;
    public double next(int i){
        sum += i;
        queue.offer(i);
        if(queue.size() > this.windowSize){
            sum -= queue.poll();
        }
        return this.sum/queue.size();
    }


    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}
