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

    private void swap(int num1, int num2){
        int temp = num1;
        num1 = num2;
        num2 = num1;
    }

    public static void main(String[] args) {
        MaximumProductSubArray obj = new MaximumProductSubArray();
        System.out.println(obj.maxProduct(new int[]{2,3,-2,4}));
    }
}
