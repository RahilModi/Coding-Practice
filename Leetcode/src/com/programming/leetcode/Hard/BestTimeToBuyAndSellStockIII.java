package com.programming.leetcode.Hard;

public class BestTimeToBuyAndSellStockIII {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39615/My-explanation-for-O(N)-solution!
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/149383/Easy-DP-solution-using-state-machine-O(n)-time-complexity-O(1)-space-complexity
    public int maxProfit(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for(int price : prices){
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1+price);
            buy2 = Math.max(buy2, sell1-price);
            sell2 = Math.max(sell2, buy2+price);
        }
        return sell2;
    }
    //For this problem K is 2 so i have hardcoded it..but can be configured like v4 solution...
    public int maxProfitCommonForKTransactions(int[] prices) {
        int k = 2;
        int n = prices.length;
        if (n <= 1) return 0;
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], localMax + prices[j]);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }

    public int MaxProfitDpCompactFinal(int[] prices)  {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;

        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }

        return sell2;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfitCommonForKTransactions(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
