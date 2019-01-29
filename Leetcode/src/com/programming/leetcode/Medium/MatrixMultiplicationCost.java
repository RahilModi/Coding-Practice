package com.programming.leetcode.Medium;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 */
public class MatrixMultiplicationCost {

    //input[] = { 5,4,6,2,7} => M1 = 5 * 4 , M2 = 4 * 6, M3 = 6 * 2, M4 = 2 * 7
    public int findMultiplicationCost(int input []){
        int[][] dp = new int[input.length][input.length];
        int q = 0;
        for(int l = 2; l < input.length;l++){
            for(int i = 0; i < input.length -l ; i++){
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i+1; k < j; k ++){
                    q = dp[i][k] + dp[k][j] + input[i]*input[j]*input[k];
                    if(q < dp[i][j]){
                        dp[i][j] = q;
                    }
                }
            }
        }
        return dp[0][input.length-1];
    }

    public static void main(String[] args) {
        MatrixMultiplicationCost mc = new MatrixMultiplicationCost();
        System.out.println(mc.findMultiplicationCost(new int[]{5,4,6,2,7}));
    }
}
