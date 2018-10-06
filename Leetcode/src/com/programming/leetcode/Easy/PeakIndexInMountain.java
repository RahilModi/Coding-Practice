package com.programming.leetcode.Easy;

public class PeakIndexInMountain {

    public int peakIndexInMountainArray(int[] A) {
        if(A.length < 3) return 0;
        for(int i = 1 ; i < (A.length - 1)  ; i++){
            if(A[i] > A[i-1] && A[i]> A[i+1]){
                return i;
            }
        }
        return 0;
    }

    public int peakIndexInMountainArrayV2(int[] A) {
        int index = -1, max = -1;
        for(int i = 0 ; i < (A.length - 1)  ; i++){
            if(A[i] > max) {
                index = i;
                max = A[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new PeakIndexInMountain().peakIndexInMountainArray(new int[]{0,2,1,0}));
    }
}
