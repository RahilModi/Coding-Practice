package com.programming.leetcode.Medium;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        int result = nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++){
            int start = i+1, end = nums.length-1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target) end--;
                else  start++;
                if(Math.abs(sum - target) < Math.abs(result - target)) result = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1,2,1,-4},1));
    }
}
