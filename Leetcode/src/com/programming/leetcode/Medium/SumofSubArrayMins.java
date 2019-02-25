package com.programming.leetcode.Medium;

import java.util.Stack;

public class SumofSubArrayMins {

    public int sumSubarrayMins(int[] A) {
        int[] prevSmaller = new int[A.length];
        int[] nextSmaller = new int[A.length];
        for(int i = 0; i <A.length; i++){
            prevSmaller[i] = i+1;
            nextSmaller[i] = A.length - i;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < A.length; i++){
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) stack.pop();
            prevSmaller[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = 0 ; i < A.length; i++){
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                nextSmaller[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        long mod = (long)1e9+7;
        long ans = 0;
        for(int i = 0; i < A.length; i++){
            ans = (ans + A[i] * prevSmaller[i] * nextSmaller[i])%mod;
        }

        return (int)ans;
    }

    public static void main(String[] args) {
        SumofSubArrayMins obj = new SumofSubArrayMins();
        System.out.println(obj.sumSubarrayMins(new int[]{3,1,4,2}));
    }

}
