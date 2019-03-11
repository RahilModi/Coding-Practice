package com.programming.leetcode.Easy;

public class IslandPerimeter {

    private int helper(int[][] grid, int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length) return 1;
        return grid[i][j] == 1 ? 0 : 1;
    }

    private int getPerimeter(int [][] grid, int i, int j){
        return helper(grid, i+1, j) + helper(grid, i-1, j) + helper(grid, i, j-1) + helper(grid, i, j+1);
    }



    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        if(grid == null || grid.length == 0) return perimeter;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) continue;
                perimeter += getPerimeter(grid, i, j);
            }
        }
        return perimeter;
    }

    public int islandPerimeterV1(int[][] grid) {
        int perimeter = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0) return perimeter;

        for(int i = 0; i< grid.length ;i++){
            for(int j=0; j< grid[0].length; j++){

                //add 4 sides
                if(grid[i][j] == 1){
                    perimeter += 4;

                    //remove the side shared between crt and upper cell
                    if(i>0 && grid[i-1][j] == 1) perimeter -= 2;

                    //remove the side shared between crt and left cell
                    if(j>0 && grid[i][j-1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }
}
