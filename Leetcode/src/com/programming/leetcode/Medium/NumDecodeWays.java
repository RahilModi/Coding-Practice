package com.programming.leetcode.Medium;

import java.util.Arrays;

public class NumDecodeWays {

    public int numDecodings(String s) {
        return s.isEmpty() ? 0 : helper(0,s);
    }

    public int helper(int p, String s){
        if(p == s.length()) return 1;
        if(s.charAt(p) == '0') return 0;
        int res = helper(p+1,s);
        if(p < s.length()-1 && (s.charAt(p)=='1'|| (s.charAt(p)=='2' && s.charAt(p) < '7'))){
            res += helper(p+2,s);
        }
        return res;
    }

    public int numDecodingsV1(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        dp[s.length()]=1;
        return s.isEmpty() ? 0 : helperV1(0, s, dp);
    }

    public int helperV1(int p, String s, int[] dp){
        if(dp[p] > -1) return dp[p];
        if(s.charAt(p) == '0') return dp[p]=0;
        int res = helperV1(p+1,s,dp);
        if(p < s.length()-1 && (s.charAt(p)=='1'|| (s.charAt(p)=='2' && s.charAt(p+1) < '7'))){
            res += helperV1(p+2,s,dp);
        }
        return dp[p]=res;
    }

    public int numDecodedingsV2(String s){
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = s.charAt(n-1) == '0' ? 0 : 1;

        for(int i = n-2; i >= 0; i--){
            if(s.charAt(i) == '0') continue;
            else{
                dp[i] = dp[i+1] + Integer.valueOf(s.substring(i,i+2)) <= 26 ?  dp[i+2] : 0;
            }
        }

        return dp[0];

    }

    public static void main(String[] args) {
        NumDecodeWays obj = new NumDecodeWays();
        System.out.println(obj.numDecodings("27"));
        System.out.println(obj.numDecodingsV1("27"));
    }
}
