package com.programming.geeksforgeeks.problems;

//https://www.geeksforgeeks.org/gold-mine-problem/
public class GoldMine {

    public int getMaxGold(int[][] gold){
        int n = gold.length;
        int m = gold[0].length;
        int [][] dp = new int[n][m];

        for(int i = m-1; i >= 0; i--){ //col
            for(int j = 0; j < n; j++){ //row

                if(i == m -1){
                    dp[j][i] = gold[j][i];
                }
                else {
                    int right = dp[j][i+1];
                    int right_up = j == 0 ? 0 : dp[j-1][i+1];
                    int right_down = j == n - 1 ? 0 : dp[j+1][i+1];
                    dp[j][i] = gold[j][i] + Math.max(right, Math.max(right_up, right_down));
                }
            }
        }
        int maxVal = 0;
        for(int i = 0; i < dp.length; i++){
            maxVal = Math.max(dp[i][0], maxVal);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[][] goldMines ={ {1, 3, 1, 5},
                             {2, 2, 4, 1},
                             {5, 0, 2, 3},
                             {0, 6, 1, 2} };
        GoldMine obj = new GoldMine();
        System.out.println(obj.getMaxGold(goldMines));

    }
}
