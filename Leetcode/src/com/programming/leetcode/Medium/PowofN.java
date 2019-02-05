package com.programming.leetcode.Medium;

public class PowofN {

    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n==1) return x;
        if(n == Integer.MIN_VALUE){
            return myPow(x*x, n/2);
        }
        if(n < 0){
            n = -n;
            x = 1/x;
        }
        return ( n % 2) == 0 ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

    public static void main(String[] args) {
        PowofN obj = new PowofN();
        System.out.println(obj.myPow(2,10));
    }
}
