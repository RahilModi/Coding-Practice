package com.programming.leetcode.Easy;

public class ClimbMountain {

    public boolean validMountainArray(int[] A) {
        if(A.length < 3) return false;
        if(A[1]<A[0]) return false;
        boolean climibing = true;
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i-1] && climibing) continue;
            else if(A[i] < A[i-1]) {
                climibing = false;
            }else{
                return false;
            }
        }
        return !climibing;
    }

    public boolean validMountainArrayV2(int[] A) {
        int n = A.length, i = 0, j = n - 1;
        while (i + 1 < n && A[i] < A[i + 1]) i++;
        while (j > 0 && A[j - 1] > A[j]) j--;
        return i > 0 && i == j && j < n - 1;
    }


    public static void main(String[] args) {
        ClimbMountain obj = new ClimbMountain();
        System.out.println( obj.validMountainArray(new int[]{0,3,2,1}));
        System.out.println(obj.validMountainArray(new int[]{3,5,5}));
        System.out.println(obj.validMountainArrayV2(new int[]{1,2,3,4,5,6,5,4,3}));
    }
}
