package com.programming.geeksforgeeks.DynamicProgramming;

//https://www.geeksforgeeks.org/subset-sum-divisible-m/
public class SubSetSumDivisibleByM {

    public boolean isSubsetSumDivisibleByM(int [] nums, int m){
        int n = nums.length;
        if(n > m) return true;
        boolean[] dp = new boolean[m];
        for(int i = 0; i < n; i++){
            if(dp[0] || (nums[i]%m) == 0) return true;
            boolean[] temp = new boolean[m];
            for(int j = 0; j < m; j++){
                if(dp[j]){
                    if(!dp[(j+nums[i])%m]){
                        temp[(j+nums[i])%m] = true;
                    }
                }
            }

            for(int j = 0; j < m; j++){
                if(temp[j]) dp[j] = true;
            }

            dp[nums[i]%m] = true;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        SubSetSumDivisibleByM obj = new SubSetSumDivisibleByM();
        System.out.println(obj.isSubsetSumDivisibleByM(new int[]{1,7,5},11));
    }
}
