package com.programming.leetcode.Medium;

public class RangeSumQuery2DImmutable {

    int[][] colSum;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        colSum = new int[matrix.length+1][matrix[0].length];
        for(int i = 1; i <= matrix.length;i++){
            for(int j = 0; j < matrix[0].length; j++){
                colSum[i][j] = colSum[i-1][j]+matrix[i-1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(colSum == null) return 0;
        int sum = 0;
        for(int j = col1; j <= col2; j++){
            sum += colSum[row2+1][j] - colSum[row1][j];
        }
        return sum;
    }

    public static void main(String[] args) {
        RangeSumQuery2DImmutable obj = new RangeSumQuery2DImmutable(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        System.out.println(obj.sumRegion(2,1,4,3));
    }
}
