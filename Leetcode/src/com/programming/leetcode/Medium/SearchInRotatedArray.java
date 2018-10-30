package com.programming.leetcode.Medium;

public class SearchInRotatedArray {


    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]){
                if(target < nums[mid] && target >= nums[left]){
                    right = mid -1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    //cliff split algorithm...
    public int searchV1(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            boolean split = (nums[mid] >= nums[0]) != (target >= nums[0]);
            if(split){
                if(target >= nums[0]){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }else{
                if(target > nums[mid]) left = mid+1;
                else right = mid;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedArray().search(new int[]{6,7,0,1,2,4,5}, 0));
        System.out.println(new SearchInRotatedArray().search(new int[]{6,7,0,1,2,4,5}, 3));

        System.out.println(new SearchInRotatedArray().searchV1(new int[]{6,7,0,1,2,4,5}, 0));
        System.out.println(new SearchInRotatedArray().searchV1(new int[]{6,7,0,1,2,4,5}, 3));
    }
}
