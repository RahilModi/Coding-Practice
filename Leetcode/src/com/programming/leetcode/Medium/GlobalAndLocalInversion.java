package com.programming.leetcode.Medium;

public class GlobalAndLocalInversion {

    //Local Inversions are part of Global Inversions when j == i + 1.
    //Thus, whenever we find inversions that j != i + 1, we return false.

    //O(N^2)
    public boolean isIdealPermutation(int[] A) {
        int numLocalInvrtions = 0, numGlobalInvertions = 0;
        for(int i = 0; i< A.length; i++){
            if(A[i] > A[i+1]) numLocalInvrtions++;
        }

        for(int i = 0; i < A.length-1; i++){
            for(int j = i+1; j < A.length;j++){
                if(A[i] > A[j]) numGlobalInvertions++;
            }
        }
        return numLocalInvrtions == numGlobalInvertions;
    }

    //O(N^2) TLE
    public boolean isIdealPermutationV1(int[] A) {
        for(int i = 0; i < A.length-1; i++){
            for(int j = i+1; j < A.length;j++){
                if(A[i] > A[j] && j != i+1) return false;
            }
        }
        return true;
    }

    //O(N)
    public boolean isIdealPermutationV2(int[] A) {
        for(int i = 0; i < A.length-1; i++){
            if(Math.abs(A[i]-i) > 1) return false;
        }
        return true;
    }


}
