package com.programming.leetcode.Medium;

public class SearchRangeInSortedArray {


    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                int i = mid, j = mid;
                while(i>0 && nums[i] == target && j<nums.length && nums[j]==target){
                    if(nums[i]==target) i--;
                    if(nums[j]==target) j++;
                }
                while(i>=0 && nums[i]==target) i--;
                while(j < nums.length && nums[j]==target) j++;
                return new int[]{i+1,j-1};
            }
            if(nums[mid] > target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return new int[]{-1,1};
    }

    public static void main(String[] args) {
        new SearchRangeInSortedArray().searchRange(new int[]{1},1);
        new SearchRangeInSortedArray().searchRange(new int[]{5,7,7,8,8,10},8);
        new SearchRangeInSortedArray().searchRange(new int[]{5,7,7,8,8,10},5);
        new SearchRangeInSortedArray().searchRange(new int[]{5,7,7,8,8,10},7);
    }

}
