package com.programming.leetcode.Easy;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int minPrice = prices[0], maxProfit = 0;
        for(int i = 1; i < prices.length ; i++){
            if(prices[i] > minPrice){
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }else{
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
        System.out.println(obj.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
