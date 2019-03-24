package com.programming.leetcode.Medium;

public class KnightProbability {

    private final int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    private double[][][] dp;
    public double knightProbability(int N, int K, int r, int c) {
        dp = new double[N][N][K+1];
        return totalPossibleMoves(N, r,c,K);
    }

    private double totalPossibleMoves(int N, int i, int j, int k){
        if(isInValid(i, j, N)) return 0;
        if(k == 0) return 1;
        if(dp[i][j][k] != 0) return dp[i][j][k];
        dp[i][j][k] = 0;
        for(int[] move : moves) {
            dp[i][j][k] += 0.125 * totalPossibleMoves(N, i + move[0], j+move[1], k-1);
        }
        return dp[i][j][k];
    }

    private boolean isInValid(int i, int j, int N){
        return (i < 0 || j < 0 || i >= N || j >= N);
    }

    public static void main(String[] args) {
        KnightProbability obj = new KnightProbability();
        System.out.println(obj.knightProbability(3,2,0,0));
    }
}
