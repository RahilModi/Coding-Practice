package com.programming.leetcode.Medium;

import java.util.Arrays;

public class WiggleSortII {

    //Virtual indexing..find median and all the elements larger then mid on the left side and smaller on the right side
    //then place larger elements at even places and smaller elements at odd places.
    //known as three way partitioning
    //virtual indexing.. color sort for index mapping..
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
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

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }


    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length+1)/2);
        int i = 0, l = 0, r = nums.length-1, n = nums.length;
        while (i <= r) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(l, n), newIndex(i, n));
                l++;
                i++;
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(r, n), newIndex(i, n));
                r--;
            } else i++;
        }
    }

    //O(nlogn) solution
    public void wiggleSortV1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int end = len, start = len % 2 == 1 ? len / 2 + 1 : len / 2;
        int[] temp = nums.clone();
        for (int i = 0; i < len; i++) {
            nums[i] = i % 2 == 0 ? temp[--start] : temp[--end];
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 5, 1, 1, 6, 4};
        WiggleSortII obj = new WiggleSortII();
        obj.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
