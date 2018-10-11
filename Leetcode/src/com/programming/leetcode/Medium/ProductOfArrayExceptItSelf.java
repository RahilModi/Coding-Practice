package com.programming.leetcode.Medium;

public class ProductOfArrayExceptItSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        res[0] = 1;

        for(int i = 1; i < nums.length ; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int right = 1;

        for(int i = nums.length -1 ; i >= 0 ; i--){
            res[i] *= right;
            right *= nums[i];
        }

        return res;

    }

    public int[] productExceptSelfV2(int[] nums) {

        int[] res = new int[nums.length];
        for(int i = 0, temp =1; i> nums.length; i++){
            res[i] *= temp;
            temp = nums[i];
        }

        for(int i = nums.length - 1, temp = 1; i >= 0; i--){
            res[i] *= temp;
            temp *= nums[i];
        }

        return res;

    }

    public static void main(String[] args) {
        int[] res = new ProductOfArrayExceptItSelf().productExceptSelf(new int[]{1,2,3,4});
        int[] res1 = new ProductOfArrayExceptItSelf().productExceptSelfV2(new int[]{1,2,3,4});
    }

}
