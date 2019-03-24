package com.programming.leetcode.Medium;

public class MinimumAsciiSumOfDeleteCharacters {

    /*
    dp[i][j] is the cost for s1.substr(0,i) and s2.substr(0, j). Note s1[i], s2[j] not included in the substring.

    Base case: dp[0][0] = 0
    target: dp[m][n]

    if s1[i-1] = s2[j-1]   // no deletion
        dp[i][j] = dp[i-1][j-1];
    else   // delete either s1[i-1] or s2[j-1]
        dp[i][j] = min(dp[i-1][j]+s1[i-1], dp[i][j-1]+s2[j-1]);
     */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int j = 1; j <= n; j++)
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        for(int i = 1; i <= m ; i++)
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1]+s2.charAt(j-1), dp[i-1][j]+s1.charAt(i-1));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        MinimumAsciiSumOfDeleteCharacters obj = new MinimumAsciiSumOfDeleteCharacters();
        System.out.println(obj.minimumDeleteSum("sea","eat"));
    }
}
