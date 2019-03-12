package com.programming.leetcode.Medium;

import java.util.Arrays;

public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int start = i+1, end = nums.length-1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum >= target) end--;
                else {
                    result+=(end-start);
                    start++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumSmaller obj = new ThreeSumSmaller();
        System.out.println(obj.threeSumSmaller(new int[]{3,1,0,-2},4));
    }

}
