package com.programming.leetcode.Easy;

public class SurfaceArea3D {

    public int surfaceArea(int[][] grid) {
        if(grid ==null || grid.length ==0) return 0;
        int totalSurfaceArea = 0;
        int N = grid.length;
        for(int i = 0; i < N ; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] > 0) totalSurfaceArea += 4 * grid[i][j] + 2;
                if(i > 0) totalSurfaceArea -= 2 * Math.min(grid[i][j], grid[i-1][j]);
                if(j > 0) totalSurfaceArea -= 2 * Math.min(grid[i][j], grid[i][j-1]);
            }
        }
        return totalSurfaceArea;
    }

    public static void main(String[] args) {
        SurfaceArea3D obj = new SurfaceArea3D();
        System.out.println(obj.surfaceArea(new int[][]{{1,2},{3,4}}));
    }

}
