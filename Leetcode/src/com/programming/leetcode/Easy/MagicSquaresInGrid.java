package com.programming.leetcode.Easy;

import java.util.Arrays;

public class MagicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid) {
        int count=0;
        for(int row = 0; row < grid.length-2; row++){
            for(int col = 0; col < grid.length-2; col++){
                if(grid[row+1][col+1]!=5) continue;
                if(magicSquare(grid[row][col],grid[row][col+1],grid[row][col+2],
                        grid[row+1][col],grid[row+1][col+1],grid[row+1][col+2],
                        grid[row+2][col],grid[row+2][col+1],grid[row+2][col+2]
                ))count++;
            }
        }
        return count;
    }

    private boolean magicSquare(int... vals){
        int count[] =new int[16];
        for(int i : vals){
            count[i]++;
        }
        for(int i = 1; i <= 9; i++){
            if (count[i]!=1) return false;
        }
        return vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15;

    }
}
