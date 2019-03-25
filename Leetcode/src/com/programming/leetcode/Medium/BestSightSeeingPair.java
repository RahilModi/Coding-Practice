package com.programming.leetcode.Medium;

public class BestSightSeeingPair {

    //https://leetcode.com/problems/best-sightseeing-pair/discuss/260909/JavaPython-Descriptive-solution.-O(N)-time-O(1)-space.-Very-similar-to-Kadence-Algo!
    //Max(A[i] + i +A[j]-j)
    public int maxScoreSightseeingPair(int[] A) {
        if(A == null || A.length < 2) return 0;
        int crtMax = A[0]+0, res = Integer.MIN_VALUE; // A[i]+i
        for(int j = 1; j < A.length; j++){
            res = Math.max(res, crtMax + A[j]-j);
            crtMax = Math.max(crtMax, A[j]+j);
        }
        return res;
    }

    public static void main(String[] args) {
        BestSightSeeingPair obj = new BestSightSeeingPair();
        System.out.println(obj.maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }
}
