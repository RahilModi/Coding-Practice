package com.programming.geeksforgeeks.DynamicProgramming;

//Cracking the Coding Interview : 8-1
public class TripleStep {

    //you can take 1, 2 or 3 step at a time so how many ways are there to reach at nth step
    public int countWaysToNthStep(int n){
        if(n <= 0) return 0;
        if(n <= 2) return n;
        if(n == 3) return 1 + countWaysToNthStep(n-1)+countWaysToNthStep(n-2);
        else {
            return countWaysToNthStep(n - 1) + countWaysToNthStep(n - 2) + countWaysToNthStep(n - 3);
        }
    }

    public long countWaysToNthStepDP(int n){
        long[] dp = new long[n+1];
        dp[1] = 1; dp[2] = 1+dp[1]; dp[3] = 1 + dp[1] + dp[2];
        for(int i = 4; i<= n; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        TripleStep obj = new TripleStep();
        System.out.println(obj.countWaysToNthStep(4));
        System.out.println(obj.countWaysToNthStepDP(5));
    }
}
