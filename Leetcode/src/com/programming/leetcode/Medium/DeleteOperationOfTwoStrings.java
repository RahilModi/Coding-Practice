package com.programming.leetcode.Medium;

public class DeleteOperationOfTwoStrings {

    //Longest Common SubSequence Problem...
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return word1 == null ? word2 != null ? word2.length() : 0 : word1.length();
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        int i=0,j=0;
        for( i = 0; i <= word1.length(); i++){
            for( j = 0; j <= word2.length(); j++){
                if(i == 0 || j==0) dp[i][j] = 0;
                else{
                    if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
                    else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return word1.length() - dp[word1.length()][word2.length()] + word2.length() - dp[word1.length()][word2.length()];
    }

    //Approach similar to Edit Distance Problem..
    public int minDistanceV1(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;

        // dp[i][j] stands for distance of first i chars of word1 and first j chars of word2
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
            dp[i][0] = i;
        for (int j = 0; j <= len2; j++)
            dp[0][j] = j;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + 2, dp[i - 1][j] + 1), dp[i][j - 1] + 1);
            }
        }

        return dp[len1][len2];
    }


    public static void main(String[] args) {
        DeleteOperationOfTwoStrings obj = new DeleteOperationOfTwoStrings();
        System.out.println(obj.minDistance("sea","eat"));
    }

}
