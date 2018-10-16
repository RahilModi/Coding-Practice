package com.programming.leetcode.Easy;

import java.util.Arrays;
import java.util.Map;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {

        int[] temp = nums.clone();

        Arrays.sort(temp);

        int left = nums.length, right = 0;
        for(int i = 0;  i < temp.length; i++){
            if(temp[i] != nums[i]){
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        return right - left < 0 ? 0 : right - left +1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2,6,4,10,8,9,15}));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2,6,4,8,9,10,15}));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2,4,8,9,10,15}));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2,3,3,2,4}));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1,2,3,3,3}));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2,1}));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1,3,2,2,2}));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1,2,4,5,3}));
    }
}
