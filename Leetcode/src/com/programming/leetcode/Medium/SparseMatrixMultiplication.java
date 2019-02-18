package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int n = A[0].length, m = A.length, mB = B[0].length;
        int[][] res = new int[m][mB];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(A[i][j] != 0) {
                    for(int k = 0; k < mB; k++){
                        if(B[j][k] != 0){
                            res[i][k] += A[i][j]*B[j][k];
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SparseMatrixMultiplication obj = new SparseMatrixMultiplication();
        System.out.println(Arrays.toString(obj.multiply(new int[][]{{1,-5}},new int[][]{{12},{-1}})));
        System.out.println(Arrays.toString(obj.multiply(new int[][]{{1,0,0},{-1,0,3}},new int[][]{{7,0,0},{0,0,0},{0,0,1}})));
    }

}
