package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class StoneGame {

    //https://leetcode.com/problems/stone-game/discuss/154610/DP-or-Just-return-true
    //only possible because given number of piles are even
    public boolean stoneGame(int[] piles) {
        return true;
    }

    private void print(int[][] matrix){
        for(int[] a : matrix){
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
    }
    //Actual way of solving the problem....
    //dp[i][j] means the biggest number of stones you can get more than opponent picking piles in piles[i] ~ piles[j].
    //You can first pick piles[i] or piles[j].
    //
    //If you pick piles[i], your result will be piles[i] - dp[i + 1][j]
    //If you pick piles[j], your result will be piles[j] - dp[i][j - 1]
    //So we get:
    //dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
    public boolean stoneGameV1(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n; i++) dp[i][i] = piles[i];
        for(int d =1; d < n; d++){
            for(int i = 0, j = i+d ; i < n-d; i++, j++){
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }

    //O(N) space
    public boolean stoneGameV3(int[] p) {
        int[] dp = Arrays.copyOf(p, p.length);;
        for (int d = 1; d < p.length; d++)
            for (int i = 0; i < p.length - d; i++)
                dp[i] = Math.max(p[i] - dp[i + 1], p[i + d] - dp[i]);
        return dp[0] > 0;
    }

    //Tushar Roy ways: https://www.youtube.com/watch?v=WxpIHvsu1RI
    class Pair{
        int first, second;

        @Override
        public String toString() {
            return "pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
    public boolean stoneGameV2(int[] piles) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                dp[i][j] = new Pair();
                if(i==j)
                    dp[i][j].first = piles[i];
            }
        }
        for(int l = 2; l <= n;l++){
            for(int i = 0; i <=n-l; i++){
                int j = i + l - 1;
                if(piles[i] + dp[i+1][j].second > piles[j]+dp[i][j-1].second){
                    dp[i][j].first = piles[i] + dp[i+1][j].second;
                    dp[i][j].second = dp[i+1][j].first;
                }else{
                    dp[i][j].first = piles[j] + dp[i][j-1].second;
                    dp[i][j].second = dp[i][j-1].first;
                }
            }
        }
        return dp[0][n-1].first > dp[0][n-1].second;
    }

    public static void main(String[] args) {
        StoneGame obj = new StoneGame();
        System.out.println(obj.stoneGameV2(new int[]{5,3,4,5}));
    }
}
