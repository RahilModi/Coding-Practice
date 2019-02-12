package com.programming.leetcode.Hard;

public class WildCardMatching {


    public boolean isMatch(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        int writeIndex = 0;
        boolean isStarFound = true;
        for(int i = 0; i < pChars.length; i++){
            if(pChars[i] == '*'){
                if(isStarFound){
                    pChars[writeIndex++] = pChars[i];
                    isStarFound = false;
                }
            }else{
                pChars[writeIndex++] = pChars[i];
                isStarFound = true;
            }
        }

        boolean[][] T = new boolean[sChars.length+1][writeIndex+1];
        T[0][0] = true;
        if(writeIndex>0 && pChars[0] == '*')
            T[0][1] = true;

        for(int i = 1; i < T.length; i++){
            for(int j = 1; j < T[0].length; j++){
                if(sChars[i-1] == pChars[j-1] || pChars[j-1]=='?'){
                    T[i][j] = T[i-1][j-1];
                }else if(pChars[j-1] =='*'){
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
            }
        }

        return T[sChars.length][writeIndex];
    }

    //O(n)
    //https://leetcode.com/problems/wildcard-matching/discuss/126185/Java-DP-solution-with-O(n)-space-with-detailed-explaination
    public boolean isMatchV1(String s, String p) {
        boolean[] dp = new boolean[s.length()+1];   // dp[i] maps to dp[i][j], where i is the length of s, j is the length of j
        char[] sStr = s.toCharArray();
        char[] pStr = p.toCharArray();
        dp[0] = true;   // before we started any iteration, dp[0] is equal to dp[0][0], meaning both s and p are EMPTY
        for (int j=1; j<=pStr.length; j++) {
            char pChr = pStr[j-1];
            if (pChr == '*') {
                // same optimization as complete backpack problem
                // we scan from 1 to s.length, so that dp[i] = dp[i] || dp[i-1]
                // just thinking like every time we iterating dp[i], the dp[i][j] we referenced is actually previous iteration's result. so dp[i-1] is actually dp[i-1][j] from previous step of current i-loop for string s, dp[i] is actually dp[i][j-1] from previous j-loop for string p
                // it's relatively easy to understand that before the dp[i]'s value is updated, dp[i] refers to dp[i][j-1]
                // the hard to understand part may be why dp[i-1] equals to dp[i-1][j]. Notice dp[i-1]'s value was updated in previous step's update (we update dp[i-1] in dp[i-2]'s step), so dp[i-1] is equal to dp[i-1][j]
                for (int i=1; i<=sStr.length; i++) {
                    dp[i] = dp[i] || dp[i-1];
                }
            } else {
                // same optimization as zero-one backpack
                // dp[i-1] means dp[i-1][j-1]
                for (int i=sStr.length; i>=1; i--) {
                    if (sStr[i-1] == pChr || pChr == '?') {
                        dp[i] = dp[i-1];
                    } else {
                        dp[i] = false;
                    }
                }
                // now, after we see the first non-'*' character, as dp[0] means dp[i][0] where i>=1, dp[i][0] it's definite false (matching empty p with non-empty s)
                // we want to set that value to false
                dp[0] = false;
            }
        }
        return dp[sStr.length];
    }

    public static void main(String[] args) {
        WildCardMatching obj = new WildCardMatching();
        System.out.println(obj.isMatch("abcdb","*a*b"));
    }


}
