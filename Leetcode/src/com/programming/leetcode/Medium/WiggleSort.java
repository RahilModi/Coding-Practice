package com.programming.leetcode.Medium;

import java.util.Arrays;

public class WiggleSort {
//    Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
//    For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4] another is [3, 5, 1, 6, 2, 4].

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            if((i&1)==1 && nums[i] < nums[i-1]){
                swap(nums,i,i-1);
            }else if((i&1)==0 && nums[i] > nums[i-1]){
                swap(nums,i,i-1);
            }
        }
    }

    public static void main(String[] args) {
        WiggleSort wiggleSort = new WiggleSort();
        int[] nums = {3,5,2,1,6,4};
        wiggleSort.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
