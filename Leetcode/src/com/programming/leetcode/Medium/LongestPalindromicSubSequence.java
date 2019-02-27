package com.programming.leetcode.Medium;

public class LongestPalindromicSubSequence {

    public int longestPalindromeSubseq(String s) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        int ans = helper(s, 0, s.length()-1, memo);
        return ans;
    }

    public int helper(String s, int i, int j,  Integer[][] memo){
        if(memo[i][j] != null) return memo[i][j];
        if(i > j) return 0;
        if(i == j) return 1;
        memo[i][j] = s.charAt(i) == s.charAt(j) ? helper(s, i+1,j-1, memo)+2 : Math.max(helper(s,i+1, j, memo), helper(s, i, j-1, memo));
        return memo[i][j];
    }

    public static void main(String[] args) {
        LongestPalindromicSubSequence obj = new LongestPalindromicSubSequence();
        System.out.println(obj.longestPalindromeSubseq("babab"));
    }
}
