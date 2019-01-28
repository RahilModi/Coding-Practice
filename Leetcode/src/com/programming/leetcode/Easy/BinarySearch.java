package com.programming.leetcode.Easy;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length -1;
        while (l <= r){
            //int mid = (l + r) >>> 1;
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) l = mid+1;
            else r = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        System.out.println(obj.search(new int[]{-1,0,3,5,9,12},12));
    }
}
