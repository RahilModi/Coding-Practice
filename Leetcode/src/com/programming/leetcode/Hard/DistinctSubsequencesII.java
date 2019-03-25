package com.programming.leetcode.Hard;

import java.util.Arrays;

// Explanation : https://www.geeksforgeeks.org/count-distinct-subsequences/
//https://leetcode.com/problems/distinct-subsequences-ii/discuss/192095/C%2B%2B-O(n)-or-O-(n)-Geeks4Geeks-improved-to-O(n)-or-O(1)
public class DistinctSubsequencesII {

    /*
    dp[i] is the number of disctinct subsequences for substring s[0..i]. It includes the empty string "" to make things easy. We'll exclude this one in the end by simply minus 1, so the answer isdp[n-1] - 1.

    If all characters are distinct, then dp[i] = dp[i-1]*2, that is all previous subsequeuences without s[i], plus all previous subsequeuences appended with s[i].

    If there are duplicate characters, We use end[c] to denote the number of distinct subsequences ending with char c so far. So number of all previous subsequences with s[i] should be subtracted by previous end[s[i]]. That is:
    dp[i] = dp[i-1] * 2 - end[s[i]]
     */
    private final int mod = (int) 1e9+7;
    public int distinctSubseqII(String S) {
        int[] dp = new int[S.length()+1];
        int[] last = new int[26];
        Arrays.fill(last,-1);
        dp[0] = 0;
        for(int i = 1; i <= S.length(); i++){
            int crtPos = S.charAt(i-1)-'a';
            if(last[crtPos] != -1) dp[i] =  2 * dp[i-1] % mod - dp[last[crtPos]] + mod;
            else dp[i] = 2 * dp[i-1] % mod + 1;
            dp[i] %= mod;
            last[crtPos] = i-1;
        }
        return dp[S.length()];
    }

    public static void main(String[] args) {
        DistinctSubsequencesII obj = new DistinctSubsequencesII();
        System.out.println(obj.distinctSubseqII("abc"));
        System.out.println(obj.distinctSubseqII("aaa"));
        System.out.println(obj.distinctSubseqII("aba"));
    }

}
