package com.programming.leetcode.Medium;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int grid[][] = new int[n][m];
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(i == 0 || j == 0) grid[i][j] = 1;
                else{
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[n-1][m-1];
    }

    public int uniquePathsBacktracking(int m, int n) {
        return backtrack(0,0,n,m);
    }

    private int backtrack(int startRow,int startCol, int boundaryRow, int boundaryCol){
        if(startCol >= boundaryCol || startRow >= boundaryRow) return 0;
        if(startCol==boundaryCol-1 && startRow==boundaryRow-1) return 1;

        return backtrack(startRow+1,startCol,boundaryRow,boundaryCol) +
                backtrack(startRow,startCol+1,boundaryRow,boundaryCol);
    }
}
