package com.programming.leetcode.Medium;

public class IntegerReplacement {

    public int integerReplacementBitManipulation(int n) {
        int c = 0;
        while (n!=1){
            if((n & 1)==0){
                n >>>=1;
            }else if(n==3 || Integer.bitCount(n+1) > Integer.bitCount(n-1)){
                n--;
            }else{
                n++;
            }
            c++;
        }
        return c;
    }

    public int integerReplacementBitManipulationV1(int n) {
        int c = 0;
        while (n!=1){
            if((n & 1)==0){
                n >>>=1;
            }else{
                int n_plus_1 = 1+ integerReplacementBitManipulationV1(n+1);
                int n_minus_1 = 1+ integerReplacementBitManipulationV1(n-1);
                c+=Math.min(n_plus_1,n_minus_1);
                break;
            }
            c++;
        }
        return c;
    }

    //Memory Limit Exceeds as StackOverFlow... because of larger value of n so deeper recursive calls causing stack overflow and large size of int array causes memory limit exception
    int[] dp;
    public int integerReplacement(int n) {
        dp = new int[n+2];
        return helper(n);
    }

    public int helper(int num){
        if(dp[num] != 0) return dp[num];
        if(num==1)return 0;
        if((num & 1) ==0) {
            dp[num] =  (1 + helper(num>>1));
            return dp[num];
        }
        else{
            dp[num+1] = helper(num+1);
            dp[num-1] = helper(num-1);
            dp[num] = (1 + Math.min(dp[num+1],dp[num-1]));
            return dp[num];
        }
    }

    public static void main(String[] args) {
        IntegerReplacement obj = new IntegerReplacement();
        System.out.println(obj.integerReplacementBitManipulationV1(8));
    }
}
