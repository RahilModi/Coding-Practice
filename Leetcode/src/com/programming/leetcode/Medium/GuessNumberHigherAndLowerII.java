package com.programming.leetcode.Medium;

import java.util.LinkedList;

public class GuessNumberHigherAndLowerII {

    //cost[1,n) = k + Max(cost([1, k-1), cost(k+1, n));
    public int getMoneyAmount(int n) {
        if(n == 1) return 0;
        int[][] dp = new int[n+1][n+1];
        for(int l = 2; l <=n ; l++){
            for(int i = 1; i <= n-(l-1); i++){
                int j = i +(l-1);
                dp[i][j] = Integer.MAX_VALUE;
                //like cost for guessing i to j
                for(int k = i; k <= j; k++){
                    int costForGuess = k;
                    costForGuess += k == n ? dp[i][k-1] : Math.max(dp[i][k-1], dp[k+1][j]);  // when k != n k+Max(dp[i][k-1], dp[k+1][j]);
                    dp[i][j] = Math.min(dp[i][j], costForGuess);
                }
            }
        }
        return dp[1][n];
    }
}
