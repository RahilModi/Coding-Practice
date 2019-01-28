package com.programming.leetcode.Medium;

import java.util.Arrays;

public class DiagonalTraversal {

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0];
        int rowPos = 0, colPos = 0, numRows = matrix.length, numCols = matrix[0].length;
        int[] arr = new int[numRows*numCols];
        int index = 0;
        boolean isUp = true;
        while(index < arr.length){
            if(isUp) {
                arr[index++] = matrix[rowPos--][colPos++];
                if (!(rowPos >= 0 && colPos <= numCols - 1)) {
                    rowPos++;
                    colPos--;
                    if (colPos < numCols - 1) colPos++;
                    else rowPos++;
                    isUp = false;
                }
            }else{
                arr[index++] = matrix[rowPos++][colPos--];
                if (!(colPos >= 0 && rowPos <= numRows - 1)) {
                    rowPos--;
                    colPos++;
                    if (rowPos < numRows - 1) rowPos++;
                    else colPos++;
                    isUp = true;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        DiagonalTraversal obj = new DiagonalTraversal();
        System.out.println(Arrays.toString(obj.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
    }


}
