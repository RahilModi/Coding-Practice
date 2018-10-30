package com.programming.leetcode.Medium;

public class FindMinimumInRotatedArray {

    public int findMin(int[] nums) {
        int left=0, right =nums.length-1;
        int min_val = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= nums[left] && nums[mid] >= nums[right] ){
                left = mid+1;
            }else{
                right = mid;
            }
            min_val = Math.min(nums[mid], min_val);
            if(left < nums.length && nums[mid]==nums[left] && nums[right]==nums[mid]) left++;
        }
        return min_val;
    }

    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedArray().findMin(new int[]{6,7,0,1,2,3,4}));
        System.out.println(new FindMinimumInRotatedArray().findMin(new int[]{3,4,5,1,2}));
        System.out.println(new FindMinimumInRotatedArray().findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(new FindMinimumInRotatedArray().findMin(new int[]{2,1}));
    }

}
