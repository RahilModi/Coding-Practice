package com.programming.leetcode.Medium;

public class SingleNonDuplicateElemInSortedArray {

    //https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/100754/Java-Binary-Search-short-(7l)-O(log(n))-w-explanations
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r){
            int mid = l + ( r - l )/2;
            if(mid % 2 == 0) {
                //mid is at even index
                if(nums[mid] == nums[mid+1]) l = mid+2;
                else r = mid;
            }else{
                //mid is at odd index
                if(nums[mid] == nums[mid-1]) l = mid+1;
                else r = mid;
            }
        }
        return nums[l];
    }

    public int singleNonDuplicateV1(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) res ^= nums[i];
        return res;
    }

    public static void main(String[] args) {
        SingleNonDuplicateElemInSortedArray obj = new SingleNonDuplicateElemInSortedArray();
        System.out.println(obj.singleNonDuplicate(new int[]{1,2,2,3,3,4,4,5,5}));
    }

}
