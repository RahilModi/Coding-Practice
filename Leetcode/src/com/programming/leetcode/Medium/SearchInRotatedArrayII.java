package com.programming.leetcode.Medium;

public class SearchInRotatedArrayII {

    public boolean search(int[] nums, int target) {

        int left = 0, right = nums.length -1;
        while(left <= right){
            int mid = left + (right -left) /2;
            if(target == nums[mid]) return true;
            if(nums[mid] < nums[right] || nums[mid] < nums[left]){
                if(target > nums[mid] &&  target <= nums[right]) left = mid+1;
                else right = mid;
            }else if(nums[mid] > nums[right] || nums[mid] > nums[left]){
                if(target < nums[mid] && target >= nums[left]) right = mid;
                else left = mid+1;
            }else{
                left++;
            }

        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedArrayII().search(new int[]{2,5,6,0,0,1,2},0));
        System.out.println(new SearchInRotatedArrayII().search(new int[]{2,5,6,0,0,1,2},3));
    }

}
