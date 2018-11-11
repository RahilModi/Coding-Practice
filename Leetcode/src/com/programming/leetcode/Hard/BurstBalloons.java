package com.programming.leetcode.Hard;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];
        for(int len = 1; len <= nums.length; len ++){
            for(int i = 0; i <= nums.length - len; i++){
                int j = i + len - 1;
                for(int k = i; k <= j ; k++){
                    int leftVal = i == 0 ? 1 : nums[i - 1] ;
                    int rightVal = j == nums.length-1 ? 1: nums[j+1];
                    int before = i == k ? 0 : dp[i][k-1];
                    int after = j == k ? 0 : dp[k+1][j];
                    dp[i][j] = Math.max(before + after + leftVal * rightVal * nums[k], dp[i][j]);
                }
            }
        }
        return dp[0][nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new BurstBalloons().maxCoins(new int[]{3,1,5,8}));
    }

}
