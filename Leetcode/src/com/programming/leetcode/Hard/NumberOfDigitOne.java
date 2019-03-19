package com.programming.leetcode.Hard;

public class NumberOfDigitOne {

    public int countDigitOne(int n) {
        int count = 0;
        long r = 0;
        for(long k = 1; k <= n; k*=10){
            r = n/k;
            count += (r + 8)/10 * k + ((r % 10 == 1) ? (n % k) + 1 : 0);
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfDigitOne obj = new NumberOfDigitOne();
        System.out.println(obj.countDigitOne(19));
    }
}
