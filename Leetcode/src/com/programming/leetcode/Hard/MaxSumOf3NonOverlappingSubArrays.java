package com.programming.leetcode.Hard;

import java.util.Arrays;

public class MaxSumOf3NonOverlappingSubArrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int numSubArrays = 3;
        int n = nums.length;
        int[][] dp = new int[numSubArrays+1][n+1];
        int[] accum = new int[n];
        for(int i = 0; i < nums.length; i++){
            if(i > 0)
                accum[i] = nums[i] + accum[i-1];
            else
                accum[i] = nums[i];
        }
        int[][] id = new int[numSubArrays+1][n+1];
        for(int i =1 ;i <numSubArrays+1; i++){
            for(int j = k-1; j < nums.length; j++){
                int crtMax = j-k < 0 ? accum[j] : accum[j] - accum[j-k] + dp[i-1][j-k];
                if(j-k>=0){
                    dp[i][j] = dp[i][j-1];
                    id[i][j] = id[i][j-1];
                }
                if(j > 0 && crtMax>dp[i][j-1]){
                    dp[i][j] = crtMax;
                    id[i][j] = j-k+1;
                }
            }
        }

        int ix = numSubArrays;
        int[] res = new int[ix];
        int prev = nums.length;
        for(int i = ix; i > 0; i--){
            res[i-1] = id[i][prev -1];
            prev = res[i-1];
        }
        return res;

    }

    public static void main(String[] args) {
        MaxSumOf3NonOverlappingSubArrays obj = new MaxSumOf3NonOverlappingSubArrays();
        System.out.println(Arrays.toString(obj.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2)));
    }

}
