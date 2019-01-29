package com.programming.leetcode.Medium;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestCommonSubsequence.java
public class LongestCommonSequence {

    public int findLCSlength(String a, String b) {
        return findLCSlengthHelper(a,b,0,0);
    }

    public int findLCSlengthHelper(String a, String b, int len1, int len2) {
        if(a.length() == len1 || b.length() == len2) return 0;
        if(a.charAt(len1) == b.charAt(len2)) return 1 + findLCSlengthHelper(a,b,len1+1, len2+1);
        else
            return Math.max(findLCSlengthHelper(a,b,len1+1, len2),findLCSlengthHelper(a,b,len1, len2+1));
    }

    public int findLCSlengthDynamic(String a, String b) {

        int[][] dp = new int[a.length()+1][b.length()+1];
        int max = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1;j< dp[i].length; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] =  Math.max(dp[i-1][j], dp[i][j-1]);
                }
                if(dp[i][j] > max) max = dp[i][j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestCommonSequence lcs = new LongestCommonSequence();
        System.out.println(lcs.findLCSlength( "abcdflqr","abdlr"));
        System.out.println(lcs.findLCSlengthDynamic( "abcdflqr","abdlr"));
    }
}
