package com.programming.leetcode.Easy;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        if(nums.length < 2) return nums[0];
        int t[] = new int[nums.length];
        int maxSum;
        t[0] = maxSum = nums[0];
        for(int i = 1; i<nums.length; i++){
            t[i] = nums[i] + (t[i-1] > 0 ? t[i-1] : 0);
            maxSum = Math.max(maxSum, t[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubArray obj = new MaximumSubArray();
        System.out.println(obj.maxSubArray(new int[]{-1,-2}));
        System.out.println(obj.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}
