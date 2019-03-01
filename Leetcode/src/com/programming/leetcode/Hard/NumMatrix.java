package com.programming.leetcode.Hard;

public class NumMatrix {
    private int[][] colSums;
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        if(   matrix == null || matrix.length    == 0 || matrix[0].length == 0   ){
            return;
        }
        this.matrix = matrix;

        colSums = new int[matrix.length + 1][matrix[0].length];
        for(int i = 1; i <= matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
            }
        }
    }
    public void update(int row, int col, int val) {
        for(int i = row + 1; i < colSums.length; i++){
            colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
        }

        matrix[row][col] = val;
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int j = col1; j <= col2; j++){
            sum += colSums[row2 + 1][j] - colSums[row1][j];
        }
        return sum;
    }

    public static void main(String[] args) {
        NumMatrix obj = new NumMatrix(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        System.out.println(obj.sumRegion(2,1,4,3));
    }
}
