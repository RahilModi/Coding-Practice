package com.programming.leetcode.Hard;

import java.util.Arrays;

public class DeleteColumnsToMakeSortedIII {
    /*
    https://leetcode.com/problems/delete-columns-to-make-sorted-iii/discuss/205679/C%2B%2BJavaPython-Maximum-Increasing-Subsequence
    Longest Increasing Sequence Approach...
     */
    public int minDeletionSize(String[] A) {
        int m = A.length, n = A[0].length(), res = n-1;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int i,j,k;
        for(j = 0; j < n; j++){
            for(i = 0; i < j ;i++){
                for(k = 0; k < m; k++){
                    if(A[k].charAt(i) > A[k].charAt(j)) break;
                }
                if(k == m){
                    dp[j] = Math.max(dp[i]+1, dp[j]);
                }
            }
            res = Math.min(res, n-dp[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSortedIII obj = new DeleteColumnsToMakeSortedIII();
        System.out.println(obj.minDeletionSize(new String[]{"babca","bbazb"}));
    }
}
