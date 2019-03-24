package com.programming.leetcode.Medium;

import java.util.Arrays;

public class MinimumFallingPathSum {

    //https://leetcode.com/problems/minimum-falling-path-sum/discuss/186666/C%2B%2BJava-4-lines-DP
    //The minimum path to get to element A[i][j] is the minimum of A[i - 1][j - 1], A[i - 1][j] and A[i - 1][j + 1].
    //Starting from row 1, we add the minumum path to each element. The smallest number in the last row is the miminum path sum.
    //Example:
    //[1, 2, 3]
    //[4, 5, 6] => [5, 6, 8]
    //[7, 8, 9] => [7, 8, 9] => [12, 13, 15]
    public int minFallingPathSum(int[][] A) {

        int minVal = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                //A[i][j] = MIN(A[i-1][j],A[i-1][j-1],A[i-1][j+1]);
                A[i][j] += Math.min(A[i-1][j], Math.min(A[i-1][Math.max(0, j-1)], A[i-1][Math.min(j+1, A.length-1)]));
                if(i == A.length-1){
                    minVal = Math.min(A[i][j], minVal);
                }
            }
        }
        return minVal == Integer.MAX_VALUE ? Arrays.stream(A[A.length-1]).min().getAsInt() : minVal;
    }
}
