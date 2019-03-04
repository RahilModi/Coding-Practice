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


    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process
    //buy[i]  = max(rest[i-1]-price, buy[i-1])
    //sell[i] = max(buy[i-1]+price, sell[i-1])
    //rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
    // also sell[i-1]= rest[i] && buy[i]<=rest[i] && rest[i]<=sell[i]
//    Substitute this in to buy[i] we now have 2 functions instead of 3:
//
//    buy[i] = max(sell[i-2]-price, buy[i-1])
//    sell[i] = max(buy[i-1]+price, sell[i-1])
    public int maxProfitV2(int[] prices){
        int prev_buy, buy, sell, prev_sell;
        prev_buy = buy = Integer.MIN_VALUE;
        prev_sell = sell = 0;
        for(int price : prices){
            prev_buy = buy;
            buy = Math.max(prev_buy, prev_sell - price);
            prev_sell = sell;
            sell = Math.max(prev_sell, prev_buy+price);
        }
        return sell;
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

    public int maxProfitStateMachine(int [] prices){
        if(prices == null || prices.length < 2) return 0;
        int days = prices.length;
        int[] rest = new int[days];
        int[] buy = new int[days];
        int[] sell = new int[days];
        buy[0] = -prices[0];
        sell[0]= Integer.MIN_VALUE;

        for(int i = 1; i < prices.length; i++){
            rest[i] = Math.max(sell[i-1], rest[i-1]);
            buy[i] = Math.max(rest[i-1]-prices[i], buy[i-1]);
            sell[i] = buy[i-1]+prices[i];
        }
        return Math.max(rest[days-1], sell[days-1]);
    }

    public static void main(String[] args) {
        System.out.println(new BuyAndSellWithCooldown().maxProfitStateMachine(new int[]{1,2,3,0,2}));
        System.out.println(new BuyAndSellWithCooldown().maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(new BuyAndSellWithCooldown().maxProfitV1(new int[]{1,2,3,0,2}));
    }

}
