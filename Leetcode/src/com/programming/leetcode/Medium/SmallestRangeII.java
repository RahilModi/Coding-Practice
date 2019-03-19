package com.programming.leetcode.Medium;

import java.util.Arrays;

public class SmallestRangeII {

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int min = A[0], max = A[A.length-1], res = max-min;
        for(int i = 0; i < A.length;i++){
            max = Math.max(A[i]+K,A[A.length-1]-K);
            min = Math.min(A[i+1]-K, A[0]+K);
            res = Math.min(res,max-min);
        }
        return res;
    }

}
