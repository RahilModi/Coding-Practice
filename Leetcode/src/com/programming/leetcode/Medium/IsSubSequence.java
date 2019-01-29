package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/is-subsequence/discuss/87302/Binary-search-solution-for-follow-up-with-detailed-comments
public class IsSubSequence {

    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for(int i = 0; i < t.length() && j < s.length(); i++){
            if(s.charAt(j)==t.charAt(i)){
                j++;
            }
        }
        return j==s.length();
    }

    /***Follow up:
        *If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
     */

    // Follow-up: O(N) time for pre-processing, O(Mlog?) for each S.
    // Eg-1. s="abc", t="bahbgdca"
    // idx=[a={1,7}, b={0,3}, c={6}]
    //  i=0 ('a'): prev=1
    //  i=1 ('b'): prev=3
    //  i=2 ('c'): prev=6 (return true)
    // Eg-2. s="abc", t="bahgdcb"
    // idx=[a={1}, b={0,6}, c={5}]
    //  i=0 ('a'): prev=1
    //  i=1 ('b'): prev=6
    //  i=2 ('c'): prev=? (return false)
    public boolean isSubsequenceForFollowUp(String s, String t) {
        List<Integer>[] idx = new List[256]; // Just for clarity
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null)
                idx[t.charAt(i)] = new ArrayList<>();
            idx[t.charAt(i)].add(i);
        }

        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx[s.charAt(i)] == null) return false; // Note: char of S does NOT exist in T causing NPE
            int j = Collections.binarySearch(idx[s.charAt(i)], prev);
            if (j < 0) j = -j - 1;
            if (j == idx[s.charAt(i)].size()) return false;
            prev = idx[s.charAt(i)].get(j) + 1;
        }
        return true;
    }

    public boolean isSubsequenceUsingIndexOf(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }

    //  tab
    //t:    a h  b   g   a   d    c
    //   a  0 4 4  4   4   -1  -1  -1
    //   b  1 1 1  -1  -1  -1  -1  -1
    //   c  6 6 6  6   6   6   6  -1
    //   g  3 3 3  3   -1  -1  -1  -1
    //   h  1 1 -1 -1  -1  -1  -1  -1
    public boolean isSubsequenceUsingDP(String s, String t) {
        // preprocessing
        // dp[i][j]: at current location j, next(include pos j)  char i+'a' first appear at location dp[i][j]
        // dp[i][j] = dp[i][j+1] except dp[t.charAt(j)-'a'][j] = j+1
        int[][] dp = new int[26][t.length()+1];
        for(int[] n:dp) Arrays.fill(n,-1);
        for(int j=t.length()-1;j>=0;j--) {
            for(int i=0;i<26;i++) {
                dp[i][j] = dp[i][j+1];
            }
            dp[t.charAt(j)-'a'][j] = j+1;
        }

        int pos = 0;
        for(char c:s.toCharArray()) { ;
            pos = dp[c-'a'][pos];
            if(pos==-1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubSequence obj = new IsSubSequence();
        System.out.println(obj.isSubsequenceForFollowUp("abc","ahbgdc"));
        System.out.println(obj.isSubsequenceForFollowUp("axc","ahbgdc"));
        System.out.println(obj.isSubsequenceUsingDP("abc","ahbgdc"));

    }
}
