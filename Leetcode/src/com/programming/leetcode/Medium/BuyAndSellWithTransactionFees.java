package com.programming.leetcode.Medium;

public class BuyAndSellWithTransactionFees {

    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for(int i = 1; i < prices.length; i++){
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash-prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        System.out.println(new BuyAndSellWithTransactionFees().maxProfit(new int[]{1,2,3,4,6,0,3,6}, 2));
    }
}
