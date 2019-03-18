package com.programming.leetcode.Medium;

import java.util.Stack;

public class ClumsyFactorial {

    public int clumsy(int N) {
        int operationOrder = 1, res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(N);
        while (N >1){
            if(operationOrder == 1){
                stack.push(stack.pop()*(--N));
            }else if(operationOrder == 2) {
                stack.push(stack.pop()/(--N));
            }else if(operationOrder == 3){
                stack.push(--N);
            }else{
                stack.push(-1 * (--N));
            }
            operationOrder ++;
            if(operationOrder%5 == 0) operationOrder = 1;
        }

        while (!stack.isEmpty()) res += stack.pop();
        return res;

    }

    public int clumsyV1(int n) {
        int ans = f(n, n - 1, n - 2, 3 - n);
        n -= 4;
        while (n > 0) {
            ans -= f(n, n - 1, n - 2, n - 3);
            n -= 4;
        }
        return ans;
    }

    private int f(int a, int b, int c, int d) {
        int e = a;
        if (b > 0) {
            e *= b;
            if (c > 0) {
                e /= c;
                if (d != 0) {
                    e -= d;
                }
            }
        }
        return e;
    }

    public static void main(String[] args) {
        ClumsyFactorial obj = new ClumsyFactorial();
        System.out.println(obj.clumsy(4));
        System.out.println(obj.clumsy(10));

    }

}
