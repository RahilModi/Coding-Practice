package com.programming.leetcode.Medium;

public class KnightDialer {

    private final int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    private int[][][] dp;
    private int mod = (int)1e9 + 7;
    public int knightDialer(int N) {
        dp = new int[4][3][N];
        int crtSum = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if( i == 3 && (j == 0 || j == 2)) continue;
                crtSum = ( crtSum + dfs(i,j, N-1) ) % mod;
            }
        }
        return crtSum;
    }

    private int dfs(int i, int j, int K){
        if(isInValid(i,j)) return 0;
        if(K == 0) return 1;
        if(dp[i][j][K] != 0) return dp[i][j][K];
        for(int[] move : moves){
            dp[i][j][K] = (dp[i][j][K] + dfs(i+move[0], j+ move[1], K-1))%mod;
        }
        return dp[i][j][K];
    }

    private boolean isInValid(int i, int j){
        if(i == 3 && ( j == 0 || j == 2)) return true;
        return (i < 0 || j < 0 || i >= 4 || j >= 3);
    }


    public int knightDialerV1(int N) {  //time n space n
        int[][] directions = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        int[][] dp = new int[N][10];
        for(int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        int mod = 1000000007;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 10; j++) {
                for(int num : directions[j]) {
                    dp[i][j] += dp[i - 1][num];
                    dp[i][j] = dp[i][j] % mod;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < 10; i++) {
            count += dp[N - 1][i];
            count = count % mod;
        }
        return count;
    }

    public static void main(String[] args) {
        KnightDialer obj = new KnightDialer();
        System.out.println(obj.knightDialer(2));
        System.out.println(obj.knightDialer(3));
    }
}
