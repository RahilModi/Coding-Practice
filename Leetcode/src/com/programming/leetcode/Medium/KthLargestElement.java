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
        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && a[++i] < a[lo]);
            while(j > lo && a[lo] < a[--j]);
            if(i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
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
