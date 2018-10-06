package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return null;
        List<Integer> result = new ArrayList<>();
        int row = 0, col = 0;
        int numRows = matrix.length-1 , numCols = matrix[row].length-1;
        while(row <= numRows && col <= numCols) {
            for(int c = col; c <= numCols ; c++) result.add(matrix[row][c]);
            for(int r = row+1; r <= numRows ; r++) result.add(matrix[r][numCols]);
            if(row < numRows && col < numCols){
                for(int c = numCols-1; c >= col; c--) result.add(matrix[numRows][c]);
                for(int r = numRows-1; r >= row+1; r--) result.add(matrix[r][col]);
            }

            row++;
            col++;
            numCols--;
            numRows--;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> temp = new SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12}});
        for(int i : temp) System.out.print(i + " ");
    }
}
