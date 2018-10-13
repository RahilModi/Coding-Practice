package com.programming.leetcode.Medium;

import java.util.Map;

public class MaxIncreseToKeepCitySkyLine {

    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int[] max_row = new int[grid.length];
        int[] max_col = new int[grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                max_row[i] = Math.max(grid[i][j], max_row[i]);
                max_col[j] = Math.max(grid[i][j], max_col[j]);
            }
        }

        int changes = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int min = Math.min(max_row[i], max_col[j]);
                changes += min - grid[i][j];
                grid[i][j] = min;
            }
        }

        return changes;
    }

    public static void main(String[] args) {
        System.out.println(new MaxIncreseToKeepCitySkyLine().maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
    }
}
