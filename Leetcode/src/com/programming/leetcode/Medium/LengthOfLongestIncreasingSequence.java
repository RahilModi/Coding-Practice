package com.programming.leetcode.Medium;

import java.util.Arrays;

public class LengthOfLongestIncreasingSequence {

    public int lengthOfLIS(int[] nums) {
        if(nums == null) return 0;
        if(nums.length < 2) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 0;
        for(int i =1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lengthOfLISV1(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LengthOfLongestIncreasingSequence obj = new LengthOfLongestIncreasingSequence();
        System.out.println(obj.lengthOfLIS(new int[]{0,8,4,12,2}));
        System.out.println(obj.lengthOfLISV1(new int[]{0,8,4,12,2}));
    }

}
