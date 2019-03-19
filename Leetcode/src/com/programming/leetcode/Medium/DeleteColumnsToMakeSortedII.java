package com.programming.leetcode.Medium;

public class DeleteColumnsToMakeSortedII {

    public int minDeletionSize(String[] A) {
        int minDelete = 0, i;
        boolean sorted[] = new boolean[A.length-1];
        for(int j = 0; j < A[0].length();j++) {
            for (i = 0; i < A.length - 1; i++) {
                if (!sorted[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
                    minDelete++;
                    break;
                }
            }
            if (i < A.length - 1) continue;
            for (i = 0; i < A.length - 1; i++) {
                if (A[i].charAt(j) < A[i + 1].charAt(j)) sorted[i] = true;
            }
        }
        return minDelete;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSortedII obj = new DeleteColumnsToMakeSortedII();
        System.out.println(obj.minDeletionSize(new String[]{"xga","xfb","yfa"}));
    }

}
