package com.programming.leetcode.Easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int queue_size;
    public KthLargest(int k, int[] nums) {
        this.queue_size = k;
        for(int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(pq.size() == this.queue_size) {
            if(pq.peek() > val){
                return pq.peek();
            }else{
                pq.poll();
            }
        }
        pq.add(val);
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3,new int[]{4,2,2,3});
        System.out.println(kthLargest.add(3));   //returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}
