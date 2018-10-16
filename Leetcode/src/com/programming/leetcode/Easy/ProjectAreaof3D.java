package com.programming.leetcode.Easy;

public class ProjectAreaof3D {

    public int projectionArea(int[][] grid) {
        return projectionAreaOfXZ(grid) + projectionAreaOfYZ(grid) + projectionAreaOfXY(grid);
    }

    private int projectionAreaOfXZ(int[][] grid){
        int crtXZ = 0;
        for(int i = 0; i < grid.length ;i++){
            int max = 0;
            for(int j = 0; j < grid[i].length; j++){
                max = Math.max(max,grid[i][j]);
            }
            crtXZ += max;
        }
        return crtXZ;
    }

    private int projectionAreaOfYZ(int[][] grid){

        int crtYZ = 0;
        for(int j = 0; j < grid[0].length ;j++){
            int max = 0;
            for(int i = 0; i < grid.length; i++){
                max = Math.max(max,grid[i][j]);
            }
            crtYZ += max;
        }
        return crtYZ;

    }

    private int projectionAreaOfXY(int[][] grid){
        int crtXY = 0;
        for(int i = 0; i < grid.length ;i++){
            for(int j = 0; j < grid[i].length; j++){
                crtXY += grid[i][j] >= 1 ? 1 : 0;
            }
        }
        return crtXY;
    }


    public static void main(String[] args) {
        ProjectAreaof3D obj = new ProjectAreaof3D();
        System.out.println(obj.projectionArea(new int[][]{{1,2},{3,4}}));
        System.out.println(obj.projectionArea(new int[][]{{2}}));
    }
}
