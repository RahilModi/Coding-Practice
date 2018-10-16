package com.programming.leetcode.Medium;

import java.util.Map;

public class HouseRobberII {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0 ) return 0;
        if(nums.length < 2) return nums[0];

        int prev = 0, cur1 = 0;
        for(int i = 0; i<nums.length-1; i++){
            int temp = prev;
            prev = cur1;
            cur1 = Math.max(temp+nums[i], prev);
        }

        prev = 0;
        int cur2 = 0;
        for(int i = 1; i<nums.length; i++){
            int temp = prev;
            prev = cur2;
            cur2 = Math.max(temp+nums[i], prev);
        }

        return Math.max(cur1,cur2);

    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{1,2,3,1}));
    }
}
