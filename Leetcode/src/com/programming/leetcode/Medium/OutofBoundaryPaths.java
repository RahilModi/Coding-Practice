package com.programming.leetcode.Medium;

public class OutofBoundaryPaths {

    int[][][] dp;
    private final int[] dirs = {0,1,0,-1,0};
    private final int mod = (int) 1e9+7;
    public int findPaths(int m, int n, int N, int i, int j) {
        dp = new int[m][n][N+1];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                for(int k = 0; k < N+1; k++) {
                    dp[r][c][k] = -1;
                }
            }
        }
        return dfs(m, n, N, i,j) % mod;

    }

    private int dfs(int m, int n, int N, int i, int j){
        if(i < 0|| j < 0 || i >= m || j >= n ) {
            return 1;
        }
        if(N == 0) return 0;
        if(dp[i][j][N] != -1) return dp[i][j][N];
        dp[i][j][N] = 0;
        for(int k = 0; k < 4; k++){
            dp[i][j][N] = (dp[i][j][N] + dfs(m,n, N-1, i+dirs[k], j+ dirs[k+1])) % mod;
        }
        return dp[i][j][N];
    }

    public static void main(String[] args) {
        OutofBoundaryPaths obj = new OutofBoundaryPaths();
        System.out.println(obj.findPaths(1,3,3,0,1));
        System.out.println(obj.findPaths(2,2,2,0,0));
    }

}
