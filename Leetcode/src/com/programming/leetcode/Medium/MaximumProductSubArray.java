package com.programming.leetcode.Medium;

public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {
        int result = nums[0];

        int crt_max = result, crt_min =result;
        for(int i = 1; i < nums.length; i++){

            int k = crt_max * nums[i];
            int m = crt_min * nums[i];

            crt_max = Math.max(nums[i], Math.max(k,m));

            crt_min = Math.min(nums[i], Math.min(k,m));

            result = Math.max(result, crt_max);

        }

        return result;
    }

    public int maxProductV1(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int res, crtMax, crtMin;
        res = crtMax = crtMin = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = crtMax;
                crtMax = crtMin;
                crtMin = temp;
            }

            crtMax = Math.max(nums[i], crtMax * nums[i]);
            crtMin = Math.min(nums[i], crtMin * nums[i]);

            res = res < crtMax ? crtMax : res;
        }
        return res;
    }

    //Easy to understand O(n) solution :
    //Its all about having odd or even numbers of negative integers.
    //if the negative numbers are even, then the first pass will give the solution.
    // If the negative numbers are odd, the second pass will give the solution.
    public int maxProductV2(int[] nums) {
        int prod = 1;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            prod = prod * nums[i];
            result = Math.max(prod, result);
            if(prod == 0) {
                prod = 1;
            }
        }
        prod = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            prod = prod * nums[i];
            result = Math.max(prod, result);
            if(prod == 0) {
                prod = 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        MaximumProductSubArray obj = new MaximumProductSubArray();
        System.out.println(obj.maxProductV1(new int[]{2,3,-2,4}));
        System.out.println(obj.maxProduct(new int[]{2,3,-2,4}));
    }
}
