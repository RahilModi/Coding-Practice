package com.programming.leetcode.Medium;

public class MaxAreaIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int maxArea = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = backtrack(i, j, grid, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }

    private int backtrack(int i, int j, int[][] grid, boolean[][] seen){
        if(i<0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || seen[i][j]) return 0;
        seen[i][j] = true;
        return 1 + backtrack(i+1, j , grid,seen) + backtrack(i-1, j,  grid,seen)
                + backtrack(i, j+1, grid,seen) + backtrack(i, j-1, grid,seen);

    }

}
