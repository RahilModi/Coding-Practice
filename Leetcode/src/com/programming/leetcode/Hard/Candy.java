package com.programming.leetcode.Hard;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        if(ratings.length <= 1)return ratings.length;

        int[] nums = new int[ratings.length];
        Arrays.fill(nums,1);
        for(int i = 1; i < nums.length; i++){
            if(ratings[i] > ratings[i-1])
                nums[i] = nums[i-1]+1;
        }
        for(int i = nums.length-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1])
                nums[i] = Math.max(nums[i+1]+1, nums[i]);
        }

        int ans = 0;
        for(int i : nums){
            ans += i;
        }
        return ans;

    }

    public static void main(String[] args) {
        Candy obj = new Candy();
        System.out.println(obj.candy(new int[]{1,2,3,2}));
    }
}
