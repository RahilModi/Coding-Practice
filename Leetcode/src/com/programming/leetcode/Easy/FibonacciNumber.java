package com.programming.leetcode.Easy;

import java.math.BigInteger;
import java.util.Arrays;

public class FibonacciNumber {

    public int findNthFibonacciNumberRecursive(int n){
        if(n == 0 || n == 1) return n;
        return findNthFibonacciNumberRecursive(n-1)+findNthFibonacciNumberRecursive(n-2);
    }

    public int findNtheFibonacciNumberDP(int n){
        int[] fib = new int[n+1];
        fib[0] = 0; fib[1] = 1;
        for(int i = 2; i<= n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }


    //O(N)
    public int findNtheFibonacciNumberDPV1(int n){
        int a, b,c;
        a =0 ; b = 1; c = a+b;
        for(int i = 2; i<= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    //O(LogN)
    int[] f = new int[100];
    int fib(int n)
    {
        // Base cases
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return (f[n] = 1);

        // If fib(n) is already computed
        if (f[n] != 0)
            return f[n];
        int k;
        if((n & 1) == 1)
            k = (n + 1) / 2 ;
        else
            k = n / 2;

        // Applying above formula
        // [Note value n&1 is 1
        // if n is odd, else 0].
        if((n & 1) == 1)
            f[n] = (fib(k) * fib(k) +
                    fib(k - 1) * fib(k - 1));
        else
            f[n] = (2 * fib(k - 1) + fib(k)) * fib(k);

        return f[n];
    }

    public BigInteger getLargeFibonacciNumbrs(int n){
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        for(int i = 2; i <= n; i++){
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }

    //(Math.sqrt(5) + 1 / 2) ^ n /Math.sqrt(5)
    public int findNthFibonacciNumberMath(int n) {
        double sqrtOfFive = Math.sqrt(5);
        return (int) (Math.round(Math.pow((sqrtOfFive + 1) / 2, n) / sqrtOfFive));
    }

    public static void main(String[] args) {
        FibonacciNumber obj = new FibonacciNumber();
        System.out.println(obj.findNthFibonacciNumberMath(3));
        System.out.println(obj.getLargeFibonacciNumbrs(100));
        System.out.println(obj.fib(10));
    }


}
