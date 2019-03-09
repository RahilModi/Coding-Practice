package com.programming.leetcode.Easy;

public class SumOfNFibonacciNumbers {

    /*
    GeeksForGeeks..
    We can rewrite the relation F(n+1) = F(n) + F(n-1) as below
    F(n-1)    = F(n+1)  -  F(n)

    Similarly,
    F(n-2)    = F(n)    -  F(n-1)
    .          .           .
    .          .             .
    .          .             .
    F(0)      = F(2)    -  F(1)
    -------------------------------
    Adding all the equations, on left side, we have
    F(0) + F(1) + … F(n-1) which is S(n-1).

    Therefore,
    S(n-1) = F(n+1) – F(1)
    S(n-1) = F(n+1) – 1
    S(n) = F(n+2) – 1
     */

    static  int [] fib = new int[1000];
    {
        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 1;
    }

    public int getSumOfNFibonacciNums(int n){
        return getNFibonaci(n+2) - 1;
    }

    //Logn fib number....
    private int getNFibonaci(int n){
            if(fib[n] != 0 || n == 0) return fib[n];
            boolean isOdd = (n & 1) == 1;
            int k = isOdd ? (n+1)/2 : n/2;
            fib[n] = isOdd ? (getNFibonaci(k) * getNFibonaci(k) + getNFibonaci(k-1) *getNFibonaci(k-1)) : (2 *getNFibonaci(k-1) + getNFibonaci(k) ) * getNFibonaci(k);
            return fib[n];
    }

    public static void main(String[] args) {
        SumOfNFibonacciNumbers obj =new SumOfNFibonacciNumbers();
        System.out.println(obj.getSumOfNFibonacciNums(5));
    }
}
