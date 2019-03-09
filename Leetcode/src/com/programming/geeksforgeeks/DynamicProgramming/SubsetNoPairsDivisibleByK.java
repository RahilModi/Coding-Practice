package com.programming.geeksforgeeks.DynamicProgramming;


import org.omg.CORBA.MARSHAL;

//https://www.geeksforgeeks.org/subset-no-pair-sum-divisible-k/
public class SubsetNoPairsDivisibleByK {

    int lengthOfLongestSubsetPairsAreNotDivisibleByK(int[] nums, int K){
        int[] dp = new int[K];
        for(int i : nums){
            dp[i%K]++;
        }
        if(K%2==0){
            dp[K/2] = Math.min(dp[K/2],1);
        }
        int res = Math.min(dp[0],1);
        for(int j = 1; j <= K/2; j++){
            res += Math.max(dp[j] , dp[K-j]);
        }
        return res;
    }

    public static void main(String[] args) {
        SubsetNoPairsDivisibleByK obj = new SubsetNoPairsDivisibleByK();
        System.out.println(obj.lengthOfLongestSubsetPairsAreNotDivisibleByK(new int[]{3,7,2,9,1}, 3));
    }

}
