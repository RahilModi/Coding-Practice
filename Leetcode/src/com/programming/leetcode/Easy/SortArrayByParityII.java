package com.programming.leetcode.Easy;

public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        for(int i = 0, j = 1; i < A.length ; i+=2){
            while(j < A.length && A[j] % 2 == 1) j+=2;
            if(A[i] % 2 == 1){
                A[i] += A[j];
                A[j] = A[i] - A[j];
                A[i] = A[i] - A[j];
                j+=2;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        SortArrayByParityII obj = new SortArrayByParityII();
        for(int i : obj.sortArrayByParityII(new int[]{4,2,5,7})){
            System.out.print(i+", ");
        };
    }
}
