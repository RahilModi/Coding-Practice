package com.programming.leetcode.Hard;

//s2[i] = max(s2[i-1], s1[i-1]+prices[i]) key understanding is explained in V3 problem..
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n <= 1) return 0;
        if(k >= n/2){
            int maxProfit = 0;
            for(int i =1 ; i<n; i++){
                if(prices[i] > prices[i-1])
                    maxProfit += prices[i]-prices[i-1];
            }
            return maxProfit;
        }

        int[][] dp = new int[k+1][n];
        for(int i = 1; i <= k; i++){
            int localMax = dp[i-1][0] - prices[0];
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.max(dp[i][j-1], localMax + prices[j]);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][n-1];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV obj = new BestTimeToBuyAndSellStockIV();
        System.out.println(obj.maxProfit(2, new int[]{3,2,6,5,0,3}));
    }
}
