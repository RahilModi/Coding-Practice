package com.programming.leetcode.Medium;

import java.util.Arrays;

public class PerfectSquares {

    /***
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    dp[4] = Math.min(dp[4 - 1*1] + 1, dp[4 - 2*2] + 1)
          = Math.min(dp[3] + 1, dp[0] + 1)
          = Math.min(4,1)
          = 1

    dp[n] = Math.min(dp[n-i*i] + 1) where n- i*i >= 0 && i >= 1
    ***/

    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i-j*j>=0){
                min = Math.min(dp[i-j*j]+1, min);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }
}
