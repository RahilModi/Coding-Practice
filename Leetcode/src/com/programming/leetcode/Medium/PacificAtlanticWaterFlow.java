package com.programming.leetcode.Medium;

import java.util.*;

public class PacificAtlanticWaterFlow {

    private final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<int[]> pacificAtlantic(int[][] matrix){
        List<int[]> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }

        boolean[][] pOcean = new boolean[matrix.length][matrix[0].length];
        boolean[][] aOcean = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            dfs(matrix, i, 0, matrix[i][0], pOcean);
            dfs(matrix, i, matrix[0].length-1, matrix[i][matrix[0].length-1], aOcean);
        }
        for(int j = 0; j < matrix[0].length; j++){
            dfs(matrix, 0, j, matrix[0][j], pOcean);
            dfs(matrix, matrix.length-1, j, matrix[matrix.length-1][j], aOcean);
        }

        for(int i = 0; i <matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(pOcean[i][j] && aOcean[i][j]) res.add(new int[]{i,j});
            }
        }
        return res;
    }

    private void dfs(int[][] A, int i, int j, int prevHeight, boolean[][] seen){
        if(i < 0 || j < 0 || i >= A.length || j >= A[0].length || seen[i][j] ||  A[i][j] < prevHeight) return;
        seen[i][j] = true;
        dfs(A, i-1,j,A[i][j], seen);
        dfs(A, i,j+1,A[i][j], seen);
        dfs(A, i,j-1,A[i][j], seen);
        dfs(A, i+1,j,A[i][j], seen);
    }

    public static void main(String[] args) {
        int[][] matrix={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        for(int[] r : new PacificAtlanticWaterFlow().pacificAtlantic(matrix)){
            System.out.println(Arrays.toString(r));
        }
    }

}
