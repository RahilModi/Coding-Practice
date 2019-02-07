package com.programming.leetcode.Medium;

import java.util.Arrays;

public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int totalNum = 0;
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i+1; j < nums.length-1; j++){
                int k = nums.length-1;
                while(j<k && (nums[i] + nums[j]) <= nums[k]){
                    k--;
                }
                if(j<k){
                    totalNum += k-j;
                }
            }
        }
        return totalNum;
    }

    public static void main(String[] args) {
        ValidTriangleNumber obj = new ValidTriangleNumber();
        System.out.println(obj.triangleNumber(new int[]{2,2,3,4,5}));
    }
}
