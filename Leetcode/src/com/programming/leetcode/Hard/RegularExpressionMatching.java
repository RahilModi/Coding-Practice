package com.programming.leetcode.Hard;

public class RegularExpressionMatching {

    //https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation
    /*1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*':
    here are two sub conditions:
            1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
            2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
    dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
    or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
    or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty*/
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatchV2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i-1) == '*' && i > 1 &&  dp[0][i-2]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1 ; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j-1) == '*') {
                    if (p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.') {
                        dp[i][j] = dp[i][j-1];
                    } else {
                        dp[i][j] = (dp[i][j-1] || dp[i-1][j] || dp[i][j-2]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatchRecursive(String s, String p) {
        return  isMatchHelper(s, p, 0,0);
    }

    public boolean isMatchHelper(String s, String p, int idS, int idP) {

        if(idP == p.length()){
            return idS == s.length();
        }

        if(idP == p.length()-1 || p.charAt(idP+1) != '*' ) {
            return idS < s.length() && ( p.charAt(idP) == s.charAt(idS) || p.charAt(idP) == '.' ) && isMatchHelper(s, p, idS + 1, idP + 1);
        }

        //0 occurrance check..
        //abc => ad*bc
        if(isMatchHelper(s,p,idS, idP+2))
            return true;

        //abbbbc => ab*c
        while (idS < s.length() && ( p.charAt(idP) == s.charAt(idS) || p.charAt(idP) == '.' ) ){
            if(isMatchHelper(s, p, idS+1, idP + 2)) return true;
            idS++;
        }
        return false;
    }


    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();
        System.out.println(obj.isMatch("aa","a*"));
        System.out.println(obj.isMatch("abbbbbbc","ad*bb*c"));
        System.out.println(obj.isMatchRecursive("abbbbb",".*"));
        System.out.println(obj.isMatchRecursive("aa","a"));

    }

}
