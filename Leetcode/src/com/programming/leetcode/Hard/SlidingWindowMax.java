package com.programming.leetcode.Hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0 ) return new int[0];

        int j = 0;

        if( k == 1) return nums;

        int[] result = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        deque.offer(0);
        for(int i = 1; i < nums.length; i++){

            while(!deque.isEmpty() && deque.peek() < i-k+1){
                deque.poll();
            }

            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }

            deque.offer(i);

            if(i >= k - 1){
                result[j++] = nums[deque.peekFirst()];
            }

        }
        return  result;
    }

    public static void main(String[] args) {
        SlidingWindowMax obj = new SlidingWindowMax();
        System.out.println(Arrays.toString(obj.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}
