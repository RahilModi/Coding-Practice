package com.programming.leetcode.Medium;

public class BombEnemies {

    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int maxEnemiesKilled = 0;for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '0'){
                    maxEnemiesKilled = Math.max(maxEnemiesKilled, helper(grid, i,j, i,j));
                }
            }
        }
        return maxEnemiesKilled;
    }

    public int helper(char[][] grid, int row, int col, int i, int j){
        if(!(row == i||col==j) || row < 0 ||col < 0 ||row>=grid.length ||col>=grid[row].length|| grid[row][col] == 'W')return 0;
        char temp = grid[row][col];
        grid[row][col]='W';
        int crtTotal = helper(grid, row+1,col,i,j)+ helper(grid, row,col+1,i,j)+helper(grid, row-1,col,i,j)+helper(grid, row,col-1,i,j);
        grid[row][col]=temp;
        return crtTotal + (grid[row][col] == 'E'?1:0);
    }


    //O(MN) time O(N)
    public int maxKilledEnemiesV1(char[][] grid) {
        if(grid == null || grid.length == 0 ||  grid[0].length == 0) return 0;
        int max = 0,row = 0;
        int[] col = new int[grid[0].length];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j] == 'W') continue;
                if(j == 0 || grid[i][j-1] == 'W'){
                    row = killedEnemiesRow(grid, i, j);
                }
                if(i == 0 || grid[i-1][j] == 'W'){
                    col[j] = killedEnemiesCol(grid,i,j);
                }
                if(grid[i][j] == '0'){
                    max = (row + col[j] > max) ? row + col[j] : max;
                }
            }

        }

        return max;
    }

    //calculate killed enemies for row i from column j
    private int killedEnemiesRow(char[][] grid, int i, int j){
        int num = 0;
        while(j <= grid[0].length-1 && grid[i][j] != 'W'){
            if(grid[i][j] == 'E') num++;
            j++;
        }
        return num;
    }
    //calculate killed enemies for  column j from row i
    private int killedEnemiesCol(char[][] grid, int i, int j){
        int num = 0;
        while(i <= grid.length -1 && grid[i][j] != 'W'){
            if(grid[i][j] == 'E') num++;
            i++;
        }
        return num;
    }

    public static void main(String[] args) {
        BombEnemies obj = new BombEnemies();
        System.out.println(obj.maxKilledEnemiesV1(new char[][]{"0E00".toCharArray(),"E0WE".toCharArray(),"0E00".toCharArray()}));
    }
}
