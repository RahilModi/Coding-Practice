package com.programming.leetcode.Hard;

public class MaxChunksToMakeSortedII {

    public int maxChunksToSorted(int[] arr) {

        int[] maxOfLeft = new int[arr.length];
        int[] minOfRight = new int[arr.length];

        maxOfLeft[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }
        minOfRight[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2; i > 0; i--){
            minOfRight[i] = Math.min(minOfRight[i+1], arr[i]);
        }

        int res = 1;
        for(int i = 0; i < arr.length-1; i++){
            if(maxOfLeft[i] <= minOfRight[i+1]) res++;
        }

        return res;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSortedII obj = new MaxChunksToMakeSortedII();
        System.out.println(obj.maxChunksToSorted(new int[]{2,1,3,4,4}));
    }

}
