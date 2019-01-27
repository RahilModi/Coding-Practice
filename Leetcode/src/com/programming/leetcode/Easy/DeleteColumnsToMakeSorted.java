package com.programming.leetcode.Easy;

public class DeleteColumnsToMakeSorted {

    public int minDeletionSize(String[] A) {
        int count = 0;
        for(int j = 0; j < A[0].length(); j++){
            for(int i = 1; i < A.length; i++){
                if(A[i-1].charAt(j) > A[i].charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
