package com.programming.leetcode.Easy;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if(prices ==null || prices.length < 2) return 0;
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            while( i < prices.length && prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
                i++;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII obj = new BestTimeToBuyAndSellStockII();
        System.out.println(obj.maxProfit(new int[]{7,1,5,3,6,4}));
    }

}
