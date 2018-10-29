package com.programming.leetcode.Medium;

public class MaxChunkToSorted {

    public int maxChunksToSorted(int[] arr) {

        int count = 0;
        Integer maxVal = Integer.MIN_VALUE;
        for(int i =0; i <arr.length; i++){
            maxVal = Math.max(maxVal, arr[i]);
            if(maxVal==i) count++;
        }
        return count;
    }

    public int maxChunksToSortedV2(int[] arr) {
        int[] maxArr = new int[arr.length];
        maxArr[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            maxArr[i] = Math.max(maxArr[i-1], arr[i]);
        }
        int count=0;
        for(int i = 0 ; i < maxArr.length ; i++){
            if(maxArr[i]==i) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println( new MaxChunkToSorted().maxChunksToSorted(new int[]{4,3,2,1,0}));
        System.out.println( new MaxChunkToSorted().maxChunksToSortedV2(new int[]{4,3,2,1,0}));
        System.out.println( new MaxChunkToSorted().maxChunksToSorted(new int[]{1,0,2,3,4}));
        System.out.println( new MaxChunkToSorted().maxChunksToSortedV2(new int[]{1,0,2,3,4}));
    }
}

