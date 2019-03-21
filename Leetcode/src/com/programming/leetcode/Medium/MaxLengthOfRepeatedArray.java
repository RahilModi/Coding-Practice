package com.programming.leetcode.Medium;

public class MaxLengthOfRepeatedArray {


    //Longest Common Substring..
    /*
     * dp[i][j] = a[i] == b[j] ? 1 + dp[i + 1][j + 1] : 0;
     * dp[i][j] : max lenth of common subarray start at a[i] & b[j];
     */
    //O(N^2) space..
    public int findLength(int[] A, int[] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0) return 0;
        int[][] dp = new int[A.length+1][B.length+1];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= B.length; j++){
                if(A[i-1] == B[j-1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    //O(N) space..
    public int findLengthV2(int[] A, int[] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0) return 0;
        int[] dp = new int[B.length+1];
        int max = Integer.MIN_VALUE;
        for(int i = A.length-1; i >=0; i--){
            for(int j = 0; j < B.length; j++){
                if(A[i] == B[j]) {
                    dp[j] = Math.max(dp[j], dp[j + 1] + 1);
                    max = Math.max(dp[j], max);
                }else{
                    dp[j] = 0;
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        MaxLengthOfRepeatedArray obj = new MaxLengthOfRepeatedArray();
        System.out.println(obj.findLength(new int[]{0,1,1,1,1}, new int[]{1,0,1,0,1}));
        System.out.println(obj.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
        System.out.println(obj.findLengthV2(new int[]{0,1,1,1,1}, new int[]{1,0,1,0,1}));
        System.out.println(obj.findLengthV2(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }

}
