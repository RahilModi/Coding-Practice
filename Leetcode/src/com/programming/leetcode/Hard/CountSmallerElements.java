package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CountSmallerElements {

    int[] binaryIndexedTree;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int min = Arrays.stream(nums).min().getAsInt();
        int[] maxArr = Arrays.stream(nums).map(n ->n - min + 1).toArray();
        int max = Arrays.stream(maxArr).max().getAsInt();
        binaryIndexedTree = new int[max+1];

        for(int j = maxArr.length-1; j >= 0; j--){
            res.add(0, get(maxArr[j]-1));
            update(maxArr[j]);
        }
        return res;
    }

    private int get(int i) {
        int num = 0;
        while (i > 0) {
            num +=this.binaryIndexedTree[i];
            i -= i&(-i);
        }
        return num;
    }
    private void update(int i) {
        while (i < this.binaryIndexedTree.length) {
            this.binaryIndexedTree[i] ++;
            i += i & (-i);
        }
    }


    public List<Integer> countSmaller_MergeSort(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int[] idxs = new int[nums.length];
        int[] count = new int[nums.length];

        for(int i = 0; i < nums.length; i++) idxs[i] = i;

        merge_sort(nums,idxs,count,0,nums.length-1);

        return Arrays.stream(count).boxed().collect(Collectors.toList());
    }

    private void merge_sort(int[] nums,int[]indexes, int[]count, int start, int end){
        if(start < end){
            int mid = start + (end-start)/2;
            merge_sort(nums,indexes,count,start,mid);
            merge_sort(nums,indexes,count,mid+1,end);

            merge(nums,indexes,count,start,end,mid);
        }
    }

    private void merge(int[] nums,int[]indexes, int[]count, int start, int end, int mid ){

        int rightPos = mid +1;
        int leftPos = start;
        int[] tmpIdx = new int[end - start +1];
        int rightcount = 0;
        int cur = 0;

        while(leftPos <= mid && rightPos <= end){
            if (nums[indexes[rightPos]] < nums[indexes[leftPos]]) {
                tmpIdx[cur++] = indexes[rightPos++];
                rightcount++;
            } else {
                tmpIdx[cur++] = indexes[leftPos];
                count[indexes[leftPos]] += rightcount;
                leftPos++;
            }
        }
        while (leftPos <= mid) {
            tmpIdx[cur++] = indexes[leftPos];
            count[indexes[leftPos]] += rightcount;
            leftPos++;
        }

        while (rightPos <= end) {
            tmpIdx[cur++] = indexes[rightPos++];
        }

        System.arraycopy(tmpIdx, 0, indexes, start, tmpIdx.length);

    }



    public static void main(String[] args) {
        System.out.println(new CountSmallerElements().countSmaller(new int[]{5,2,6,1}));
        System.out.println(new CountSmallerElements().countSmaller_MergeSort(new int[]{5,2,6,1}));
    }
}
