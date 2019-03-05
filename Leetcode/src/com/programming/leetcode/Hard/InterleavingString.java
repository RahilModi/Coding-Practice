package com.programming.leetcode.Hard;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length ; j++) {
                int l = i + j - 1;
                if (i == 0 || j == 0) {
                    if (i == 0 && j == 0) dp[i][j] = true;
                    else if (j > 0) {
                        if (s3.charAt(l) == s2.charAt(j - 1)) dp[i][j] = dp[i][j - 1];
                    } else if (i > 0) {
                        if (s3.charAt(l) == s1.charAt(i - 1)) dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = (s3.charAt(l) == s2.charAt(j - 1) ? dp[i][j-1] : false) || (s3.charAt(l) == s1.charAt(i - 1) ? dp[i-1][j] : false);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
