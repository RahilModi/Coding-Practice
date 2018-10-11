package com.programming.leetcode.Easy;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {

        int count = 0;
        while(n > 0){
            count += n/5;
            n/=5;
        }

        return count;

    }

    public int trailingZeroesv2(int n) {

        return n == 0? 0 : n/5 + trailingZeroesv2(n/5);

    }


    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(15));
        System.out.println(new FactorialTrailingZeroes().trailingZeroesv2(5));
    }
}
