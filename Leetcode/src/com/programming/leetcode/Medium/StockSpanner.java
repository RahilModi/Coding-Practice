package com.programming.leetcode.Medium;

import java.util.Stack;

public class StockSpanner {
    Stack<Integer> stockPrices, weights;
    public StockSpanner() {
        stockPrices = new Stack<>();
        weights = new Stack<>();
    }

    public int next(int price) {
        int w = 1;
        while (!stockPrices.isEmpty() && stockPrices.peek() <= price){
            stockPrices.pop();
            w += weights.pop();
        }
        stockPrices.push(price);
        weights.push(w);
        return w;
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(89));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(90));
    }
}
