package com.programming.leetcode.Easy;

public class MinCostToClimbStairs {

    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0)return 0;
        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = Math.min(2* cost[0], cost[1]);
        for(int i = 2; i <= cost.length; i++){
            int crtCost = i==cost.length ? 0 : cost[i];
            dp[i] = Math.min(dp[i-1]+crtCost , dp[i-2]+crtCost);
        }
        return dp[cost.length];
    }

}
