package com.programming.geeksforgeeks.DynamicProgramming;

import java.util.Arrays;

//https://www.geeksforgeeks.org/largest-divisible-pairs-subset/
public class LargestDivisiblePairSubset {

    int largestDivisiblePairSubset(int [] nums){
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.sort(nums);
        dp[n-1] = 1;
        for(int i = n-2; i >= 0 ; i--){
            int max = 0;
            for(int j = i+1; j < n; j++){
                if(nums[j] % nums[i] == 0){
                    max =Math.max(max, dp[j]);
                }
            }
            dp[i] = 1 + max;
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        LargestDivisiblePairSubset obj = new LargestDivisiblePairSubset();
        System.out.println(obj.largestDivisiblePairSubset(new int[]{1,3, 6,13, 17,18}));
    }
}
