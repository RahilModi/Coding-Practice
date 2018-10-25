package com.programming.leetcode.Easy;

import com.programming.leetcode.Medium.MapSum;

public class MaxAvgSubArray {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0, maxSum = Integer.MIN_VALUE;
        int index = 0;
        while(index < nums.length){
            sum += nums[index];
            if(index >= (k - 1)){
                maxSum = Math.max(maxSum, sum);
                sum -= nums[index - (k-1)];
            }

            index++;
        }
        return maxSum/k;
    }

    public static void main(String[] args) {
        System.out.println(new MaxAvgSubArray().findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
