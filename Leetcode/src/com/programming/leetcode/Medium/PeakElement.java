package com.programming.leetcode.Medium;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid+1] > nums[mid]) left = mid+1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        PeakElement obj = new PeakElement();
        System.out.println(obj.findPeakElement(new int[]{1,2,3,4,5,4,5,6,7}));
    }
}
