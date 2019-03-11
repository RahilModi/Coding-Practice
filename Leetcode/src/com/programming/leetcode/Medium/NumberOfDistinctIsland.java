package com.programming.leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIsland {

    /*
        Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
        Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

        Example 1:
        11000
        11000
        00011
        00011
        Given the above grid map, return 1.
     */
    public int numDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, sb, 'o');
                    islands.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        return islands.size();
    }

    public void dfs(int [][] grid, int i, int j, StringBuilder sb, char dir){
        if(i <0 || j < 0 || i >= grid.length || j>= grid[0].length || grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] =0;
        dfs(grid,i+1, j, sb, 'd');
        dfs(grid,i-1, j, sb, 'u');
        dfs(grid,i, j-1, sb, 'l');
        dfs(grid,i, j+1, sb, 'r');
        sb.append('b');
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1}, {0,0,0,1,1}};
        int[][] grid1 = {{1,1,0},{0,1,1},{0,0,0},{1,1,1},{0,1,0}};
        System.out.println(new NumberOfDistinctIsland().numDistinctIslands(grid1));
    }

}
