package com.programming.leetcode.Hard;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MedianFinder {


    //Another Approach is build Balanced BST...

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {

    }

    public void addNum(int num) {
        if(minHeap.isEmpty()) {
            minHeap.add(num);
            return;
        }
        if(num < findMedian())
            maxHeap.add(num);
        else
            minHeap.add(num);
        if((minHeap.size() - maxHeap.size()) > 1){
            maxHeap.add(minHeap.poll());
        }else if(maxHeap.size() > minHeap.size()){
            minHeap.add(maxHeap.poll());
        }

    }

    public double findMedian() {
        if(maxHeap.isEmpty() && minHeap.isEmpty()) return 0;
        if(maxHeap.size() == minHeap.size()) return (double) (maxHeap.peek() + minHeap.peek())/2.0;
        else
            return minHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(6);
        obj.addNum(10);
        obj.addNum(2);
        obj.addNum(6);
        obj.addNum(5);
        System.out.println(obj.findMedian());

    }
}
