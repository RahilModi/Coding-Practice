package com.programming.leetcode.Hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[]res = new double[nums.length-k+1];
        for(int i = 0; i <= nums.length; i++){
            if(i >= k){
                res[i-k] = getMedian();
                remove(nums[i-k]);
            }
            if (i<nums.length)
                add(nums[i]);
        }
        return res;
    }

    public void remove(int i){
        if(i < getMedian()){
            maxHeap.remove(i);
        }else{
            minHeap.remove(i);
        }
        rebalance();
    }

    private void rebalance() {
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public void  add(int num){
        if(minHeap.isEmpty()){
            minHeap.add(num);
            return;
        }
        if(num < getMedian()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        rebalance();
    }

    public double getMedian(){
        if (minHeap.isEmpty() && maxHeap.isEmpty()) return 0;
        if(minHeap.size() == maxHeap.size()) return (maxHeap.peek() + minHeap.peek())/2.0;
        else{
            return (double) minHeap.peek();
        }
    }





    public static void main(String[] args) {
        SlidingWindowMedian obj = new SlidingWindowMedian();
        System.out.println(Arrays.toString(obj.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }

}
