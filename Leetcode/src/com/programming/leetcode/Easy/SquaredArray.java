package com.programming.leetcode.Easy;

public class SquaredArray {
    public int[] sortedSquares(int[] A) {
        int[] squaredArray = new int[A.length];
        int i = 0, j = A.length - 1;

        for (int k = A.length - 1; k >= 0; k--) {
            if (A[j] * A[j] > A[i] * A[i]) {
                squaredArray[k] = A[j] * A[j];
                j--;
            } else {
                squaredArray[k] = A[i] * A[i];
                i++;
            }
        }
        return squaredArray;
    }
}
