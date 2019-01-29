package com.programming.leetcode.Medium;

import java.util.Arrays;

/****
 *  *
 *  * Given a total and coins of certain denominations find number of ways total
 *  * can be formed from coins assuming infinity supply of coins
 *  *
 *  * References:
 *  https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 */
public class MinimumCoinChanging {

    //Psuedo Algorithms

    /**
     * If V == 0, then 0 coins required.
     * If V > 0
     *    minCoin(coins[0..m-1], V) = min {1 + minCoins(V-coin[i])}
     *                                where i varies from 0 to m-1
     *                                and coin[i] <= V
     * @param coins
     * @param target
     * @return
     */
    public int minCoins(int[] coins, int target){
        if(target == 0) return 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= target){
                int sub = minCoins(coins, target-coins[i]);
                if(sub != Integer.MAX_VALUE && res > sub+1){
                    res = sub + 1;
                }
            }
        }
        return res;
    }
    //The time complexity of above solution is exponential. If we draw the complete recursion tree, we can observer that many subproblems are solved again and again. For example, when we start from V = 11, we can reach 6 by subtracting one 5 times and by subtracting 5 one times. So the sub-problem for 6 is called twice.
    public int miniMumCoinChangeDP(int[] coins, int target){
        Arrays.sort(coins);
        if(target==0) return 0;
        int [] table = new int[target+1];
        table[0] = 0;
        Arrays.fill(table,1,target+1,Integer.MAX_VALUE);
        for(int i = 1; i <= target; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i){
                    int val = table[i-coins[j]];
                    if(val != Integer.MAX_VALUE && (val + 1) < table[i])
                        table[i] = val+1;
                }
            }
        }
        return table[target];
    }

    public int numberOfSolutionsOnSpace(int total, int coins[]){
        int temp[] = new int[total+1];
        temp[0] = 1;
        for(int i=0; i < coins.length; i++){
            for(int j=1; j <= total ; j++){
                if(j >= coins[i]){
                    temp[j] += temp[j-coins[i]];
                }
            }
        }
        return temp[total];
    }

    public static void main(String[] args) {
        int[] coins = {9,6,5,1};
        System.out.println(new MinimumCoinChanging().miniMumCoinChangeDP(coins,12));
        System.out.println(new MinimumCoinChanging().minCoins(coins,12));
    }
}
