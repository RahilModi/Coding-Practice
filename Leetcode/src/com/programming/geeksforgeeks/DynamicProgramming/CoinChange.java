package com.programming.geeksforgeeks.DynamicProgramming;

import java.util.Arrays;

//https://www.geeksforgeeks.org/coin-change-dp-7/
public class CoinChange {

    public int numWaysOfCoinChange(int[] coins, int amount){
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int c : coins){
            for(int i = c; i <= amount; i++){
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }

    public int numWaysOfCoinChangeRecursive(int[] coins, int amount, int pos){
        if(amount == 0) return 1;
        if(amount < 0||(pos <= 0 && amount >= 1)) return 0;
        return numWaysOfCoinChangeRecursive(coins, amount, pos-1) + numWaysOfCoinChangeRecursive(coins, amount-coins[pos-1], pos);
    }

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        System.out.println(obj.numWaysOfCoinChange(new int[]{1,2,3}, 4));
        System.out.println(obj.numWaysOfCoinChangeRecursive(new int[]{1,2,3}, 4, 3));
    }



}
