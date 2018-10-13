package com.programming.leetcode.Medium;

import java.util.Random;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {
        int pivot = a[lo];
        int pivotIndex = lo;
        lo++;
        while(lo <= hi){
            if(a[lo] < pivot ) lo++;
            else if(a[hi] >= pivot) hi--;
            else{
                swap(a,lo,hi);
            }
        }
        swap(a, pivotIndex, hi);
        return lo;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void shuffle(int[] arr) {
        Random r = new Random();
        int range = arr.length;
        for(int i=0; i<range; i++) {
            int swapIndex = r.nextInt(range);
            swap(arr,i,swapIndex);
        }
    }



    public static void main(String[] args) {
        System.out.println(new KthLargestElement().findKthLargest(new int[]{1,23,5,32,81,92,23},4));
    }
}
