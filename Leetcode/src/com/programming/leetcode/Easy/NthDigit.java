package com.programming.leetcode.Easy;

public class NthDigit {

    public int findNthDigit(int n) {
        int digits = 1;
        long count= 9;
        int res = 1;
        while(n > digits * count){
            n -= digits*(int)count;
            digits++;
            count *=10;
            res *= 10;
        }
        res += (n-1)/digits;
        return Character.getNumericValue(Integer.toString(res).charAt((n-1) % digits));
    }

    public static void main(String[] args) {
        NthDigit obj = new NthDigit();
        System.out.println(obj.findNthDigit(23));
    }

}
