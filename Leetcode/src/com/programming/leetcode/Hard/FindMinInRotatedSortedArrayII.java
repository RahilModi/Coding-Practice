package com.programming.leetcode.Hard;

public class FindMinInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min_val = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (right+left) >>> 1;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }else{
                //nums[mid] == nums[right] => [2,3,4,5,5,5,5]
                if(nums[left] == nums[mid]){
                    left++;right--;
                }else
                    right=mid;
            }
        }
        return nums[left]; //both are working fine nums[right]
    }

    public static void main(String[] args) {
        FindMinInRotatedSortedArrayII obj = new FindMinInRotatedSortedArrayII();
        System.out.println(obj.findMin(new int[]{2,2,2,0,1,2}));
        System.out.println(obj.findMin(new int[]{4,5,6,7,0,1,2,3}));
    }
}
