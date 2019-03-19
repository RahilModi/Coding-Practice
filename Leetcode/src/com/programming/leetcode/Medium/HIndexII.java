package com.programming.leetcode.Medium;

public class HIndexII {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        return binarySearchHelper(citations);
    }

    private int binarySearchHelper(int[] A){
        int left = 0, right = A.length-1, len = A.length, mid;
        while (left <= right){
            mid = left+(right-left)/2;
            if(A[mid] == len - mid) return A[mid];
            else if(A[mid] > len - mid) right = mid-1;
            else left = mid+1;
        }
        return len-left;
    }

    public static void main(String[] args) {
        HIndexII obj = new HIndexII();
        System.out.println(obj.hIndex(new int[]{0,1,3,5,6}));
    }
}
