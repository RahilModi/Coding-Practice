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

    //same as above  but more dp like solution rather than using variables...
    public int maxProfitV1(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int days = prices.length, buy[] = new int[days], sell[] = new int[days];
        buy[0]=-prices[0]-fee;
        for (int i = 1; i<days; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - fee); // keep the same as day i-1, or buy from sell status at day i-1
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]); // keep the same as day i-1, or sell from buy status at day i-1
        }
        return sell[days - 1];
    }

    public static void main(String[] args) {
        System.out.println(new BuyAndSellWithTransactionFees().maxProfit(new int[]{1,2,3,4,6,0,3,6}, 2));
    }
}
