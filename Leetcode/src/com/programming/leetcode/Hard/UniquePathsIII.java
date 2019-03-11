package com.programming.leetcode.Hard;

public class UniquePathsIII {

    int res = 0, empty = 1;
    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY=0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) {
                    empty++;
                }
                else if(grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        backtrack(grid, startX, startY);
        return res;
    }

    public void backtrack(int[][] grid, int i, int j){
        if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] >= 0){
            if(grid[i][j] == 2){
                if(empty == 0) {
                    res++;
                }
                return;
            }
            grid[i][j] = -2;
            empty--;
            backtrack(grid, i+1, j);
            backtrack(grid, i-1, j);
            backtrack(grid, i, j+1);
            backtrack(grid, i, j-1);
            empty++;
            grid[i][j] = 0;
        }
    }
}
