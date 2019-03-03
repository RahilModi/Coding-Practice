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

    public int robV1(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        if(nums.length < 3) return Math.max(nums[0], nums.length > 1 ? nums[1] : 0);
        //check for path from 0 to n-2 OR 1 to n-1 so cyclic array condition can be avoided
        return Math.max(robHelper(nums, 0, nums.length-2), robHelper(nums, 1, nums.length-1));
    }

    public int robHelper(int[] nums, int lo, int hi){
        int prev = 0, crt = 0;
        for(int i = lo; i <= hi; i++){
            int temp = prev;
            prev = crt;
            crt = Math.max(temp + nums[i], prev);
        }
        return crt;
    }
    public static void main(String[] args) {
        System.out.println(new HouseRobberII().robV1(new int[]{1,2,3,1}));
    }
}
