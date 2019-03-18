package com.programming.leetcode.Medium;

public class MaxSumCircularSubArray {

    //https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass
    public int maxSubarraySumCircular(int[] A) {
        int crtMax = 0, crtMin = 0, maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE, total = 0;
        for(int num : A){
            crtMax = Math.max(num, crtMax + num);
            maxSum = Math.max(crtMax, maxSum);
            crtMin = Math.min(num, crtMin + num);
            minSum = Math.min(crtMin, minSum);
            total += num;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

}
