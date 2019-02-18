package com.programming.leetcode.Hard;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {
    /* first  consider the situation matrix is 1D
    we can save every sum of 0~i(0<=i<len) and binary search previous sum to find
    possible result for every index, time complexity is O(NlogN).
    so in 2D matrix, we can sum up all values from row i to row j and create a 1D array
    to use 1D array solution.
    If col number is less than row number, we can sum up all values from col i to col j
    then use 1D array solution.
*/
    public int maxSumSubmatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = Math.min(matrix.length, matrix[0].length);
        int n = Math.max(matrix.length, matrix[0].length);
        boolean isColBig = matrix[0].length > matrix.length;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < m ; i++){
            int[] arr= new int[n];
            for(int j = i; j >= 0; j--){
                TreeSet<Integer> set= new TreeSet<>();
                set.add(0);
                int val = 0;
                for(int k = 0; k < n; k++){
                    //to handle numcol is more than numrows.
                    arr[k] += isColBig ? matrix[j][k] : matrix[k][j];
                    val += arr[k];
                    //binary search to find least bigger sum than val-target
                    Integer temp = set.ceiling(val-target);
                    if(temp != null){
                        res = Math.max(val-temp, res);
                        if(res==target) return res;
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,0,1},{0,-2,3}};
        MaxSumOfRectangleNoLargerThanK obj = new MaxSumOfRectangleNoLargerThanK();
        System.out.println(obj.maxSumSubmatrix(matrix, 2));
    }

}
