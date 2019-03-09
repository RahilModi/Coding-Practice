package com.programming.leetcode.Medium;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        boolean rowZero = false, colZero = false;
        for(int i = 0; i < matrix.length; i++) if(matrix[i][0]==0) {
            colZero = true;
            break;
        }
        for(int j = 0; j < matrix.length; j++) if(matrix[0][j] == 0){
            rowZero = true;
            break;
        }

        for(int i =1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                int j = 0;
                while (j < matrix[i].length){
                    matrix[i][j++] = 0;
                }
            }
        }

        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                int j = 0;
                while (j < matrix.length){
                    matrix[j++][i] = 0;
                }
            }
        }

        if(rowZero) {
            for (int i = 0; i< matrix[0].length; i++){
                matrix[0][i]= 0;
            }
        }
        if(colZero){
            for (int j = 0; j < matrix.length; j++){
                matrix[j][0] = 0;
            }
        }
        return;

    }
}
