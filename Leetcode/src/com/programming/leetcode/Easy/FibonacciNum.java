package com.programming.leetcode.Easy;

public class FibonacciNum {
    public int fib(int N) {
        int[] arr = new int[N+1];
        for(int i = 0; i <= N; i++){
            if(i == 0) arr[i] = 0;
            else if(i == 1) arr[i] = 1;
            else
                arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[N];
    }

    public int  fibRec(int n){
        if(n == 0 || n == 1) return n;
        return fibRec(n-1)+fibRec(n-2);
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciNum().fib(10));
        System.out.println(new FibonacciNum().fibRec(10));
    }
}
