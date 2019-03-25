package com.programming.leetcode.Easy;

public class ArrangeCoins {

    public int arrangeCoins(int n) {
        int i = 1;
        n -= i;
        while(n > 0){
            n-=(++i);
        }
        return n == 0 ? i : i-1;
    }

    public static void main(String[] args) {
        ArrangeCoins obj = new ArrangeCoins();
        System.out.println(obj.arrangeCoins(8));
    }
}
