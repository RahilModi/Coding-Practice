package com.programming.leetcode.Medium;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        for(int i = 0; i <m; i++){
            for(int j = 0; j <n;j++){
                if(obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                    continue;
                }
                else if(i == 0 || j ==0){
                    if(i == 0 && j > 0) paths[i][j] = paths[i][j-1];
                    if(j == 0 && i > 0) paths[i][j] = paths[i-1][j];
                }else{
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
        }
        return paths[m-1][n-1];
    }

    public int uniquePathsIIBacktrack(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0)return 0;
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        return backtrack(0,0,n,m, obstacleGrid);
    }

    private int backtrack(int startRow,int startCol, int boundaryRow, int boundaryCol, int[][]obstacleGrid){
        if(startCol >= boundaryCol || startRow >= boundaryRow || obstacleGrid[startRow][startCol] == 1 ) return 0;
        if(startCol==boundaryCol-1 && startRow==boundaryRow-1) return 1;

        return backtrack(startRow+1,startCol,boundaryRow,boundaryCol, obstacleGrid) +
                backtrack(startRow,startCol+1,boundaryRow,boundaryCol,obstacleGrid);
    }
}
