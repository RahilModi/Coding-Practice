package com.programming.leetcode.Medium;

public class BuyAndSellWithCooldown {

    public int maxProfit(int[] prices) {

        int profit1 = 0, profit2 = 0;

        for(int i = 1; i < prices.length; i++){
            int prevProfit1 = profit1;
            profit1 = Math.max(profit1+prices[i]-prices[i-1], profit2);
            profit2 = Math.max(prevProfit1, profit2);
        }
        return Math.max(profit1, profit2);
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
    public int maxProfitV1(int[] prices){
        int prev_rest = 0, crt_rest=0;
        int prev_buy = ~prices[0]+1, crt_buy;
        int prev_sell = Integer.MIN_VALUE , crt_sell=0;

        for(int i = 1; i < prices.length ; i++){
            crt_rest = Math.max(prev_rest, prev_sell);
            crt_buy = Math.max(prev_rest-prices[i], prev_buy);
            crt_sell = prev_buy + prices[i];

            prev_buy = crt_buy;
            prev_rest = crt_rest;
            prev_sell = crt_sell;
        }

        return Math.max(crt_rest, crt_sell);
    }

    public static void main(String[] args) {
        System.out.println(new BuyAndSellWithCooldown().maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(new BuyAndSellWithCooldown().maxProfitV1(new int[]{1,2,3,0,2}));
    }

}
