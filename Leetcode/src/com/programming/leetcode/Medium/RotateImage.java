package com.programming.leetcode.Medium;

import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {

        int h = matrix.length-1, w = matrix[0].length-1;
        for(int i = 0; i< (h+1)/2; i++){
            for(int j = i; j < w - i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[h-j][i];
                matrix[h-j][i] = matrix[h-i][w-j];
                matrix[h-i][w-j] = matrix[j][w-i];
                matrix[j][w-i] = temp;
            }
        }
    }

    private void print(int [][] matrix){
        for(int[] m : matrix){
            System.out.println(Arrays.toString(m));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        RotateImage obj = new RotateImage();
        obj.rotate(matrix);
        obj.print(matrix);
    }

}
