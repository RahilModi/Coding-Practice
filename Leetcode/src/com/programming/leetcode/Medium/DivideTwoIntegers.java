package com.programming.leetcode.Medium;

public class DivideTwoIntegers {

    public int ldivide(int dividend, int divisor) {
        int sign = 1;
        if((dividend < 0) ^ (divisor < 0)){
            sign = -1;
        }

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        long lans = ldivide(ldividend, ldivisor);
        return lans > Integer.MAX_VALUE ? ((sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE) : (int) (sign*lans);
    }

    public long ldivide(long dividend, long divisor) {
        if(dividend < divisor) return 0;

        long sum = divisor;
        long multiplier = 1;
        while ((sum+sum) <= dividend){
            sum +=sum;
            multiplier *=2;
        }
        return multiplier + ldivide(dividend-sum, divisor);

    }

    public static void main(String[] args) {
        DivideTwoIntegers obj = new DivideTwoIntegers();
        System.out.println(obj.ldivide(-2147483648, -1));
    }
}
