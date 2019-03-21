package com.programming.leetcode.Medium;

public class NumberOfSubArraysWithBoundedMaximum {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res= 0 , crtMax;
        for(int i = 0; i < A.length; i++){
            if(A[i] > R) continue;
            crtMax = -1;
            for(int j = i; j < A.length; j++){
                crtMax = Math.max(crtMax, A[j]);
                if(crtMax > R) break;
                if(crtMax >= L) res++;
            }
        }
        return res;
    }

    public int numSubarrayBoundedMaxV1(int[] A, int L, int R) {
        return numSubArrayMaxBoundHelper(A, R) - numSubArrayMaxBoundHelper(A, L-1);
    }

    //find number of subarrays whose max element is less or equal to R.
    private int numSubArrayMaxBoundHelper(int[] A, int R){
        int crt = 0, ans = 0;
        for(int i : A){
            crt = i <= R ? crt+1 : 0;
            ans+=crt;
        }
        return ans;
    }




    public static void main(String[] args) {
        NumberOfSubArraysWithBoundedMaximum obj = new NumberOfSubArraysWithBoundedMaximum();
        System.out.println(obj.numSubarrayBoundedMaxV1(new int[]{2,1,4,3},2,3));
        System.out.println(obj.numSubarrayBoundedMax(new int[]{2,1,4,3},2,3));
    }
}
