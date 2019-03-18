package com.programming.leetcode.Medium;

public class TwoKeyKeyboard {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for(int i = 2; i<=n; i++){
            dp[i] = i;
            for(int j = i-1; j > 1; j--){
                if(i%j == 0){
                    dp[i] = dp[j] + (i/j);
                    break;
                }
            }
        }
        return dp[n];
    }

    public int minStepsV1(int n) {
        int s = 0;
        for (int d = 2; d <= n; d++) {
            while (n % d == 0) {
                s += d;
                n /= d;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        TwoKeyKeyboard obj = new TwoKeyKeyboard();
        System.out.println(obj.minSteps(5));
    }
}
