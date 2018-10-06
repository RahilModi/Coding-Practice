package com.programming.leetcode.Medium;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int row = 0, numRows = n-1, col = 0, numCols = n-1;
        int i = 1;
        while(row <= numRows && col <= numCols){
            for(int c = col; c <= numCols; c++) {
                matrix[row][c] = i++;
            }
            for(int r = row+1; r <= numRows ; r++){
                matrix[r][numCols] = i++;
            }
            if(row < numRows && col < numCols){
                for(int c = numCols -1 ; c > col; c--){
                    matrix[numRows][c] = i++;
                }
                for(int r = numRows; r > row ;r--){
                    matrix[r][col] = i++;
                }
            }

            row++;
            col++;
            numCols--;
            numRows--;
        }

        return matrix;

    }

    public static void main(String[] args) {
        int[][] matrix = new SpiralMatrixII().generateMatrix(4);
        for(int i = 0 ; i <matrix.length; i++){
            for(int c = 0; c <matrix[i].length; c++){
                System.out.print(matrix[i][c] + " ");
            }
            System.out.println();
        }
    }

}
