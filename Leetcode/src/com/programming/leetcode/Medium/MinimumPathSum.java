package com.programming.leetcode.Medium;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int dp[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j];
                if (i == 0 || j == 0) {
                    if(i == 0 && j > 0){
                        dp[i][j] += dp[i][j-1];
                    }
                    if(j == 0 && i > 0){
                        dp[i][j] += dp[i-1][j];
                    }
                }
                else {
                    dp[i][j] += Math.min(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}

