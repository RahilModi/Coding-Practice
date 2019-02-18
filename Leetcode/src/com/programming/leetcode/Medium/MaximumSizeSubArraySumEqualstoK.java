package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubArraySumEqualstoK {

    //o(n^2)
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int  j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k) maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }

    public int maxSubArrayLenV1(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int sum = 0, maxLen =0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum==k) maxLen = i +1;
            else if(countMap.containsKey(sum-k)) maxLen = Math.max(maxLen, i-countMap.get(sum-k));
            if(!countMap.containsKey(sum)) countMap.put(sum,i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaximumSizeSubArraySumEqualstoK obj = new MaximumSizeSubArraySumEqualstoK();
        System.out.println(obj.maxSubArrayLenV1(new int[]{1, -1, 5, -2, 3, -2},3));
    }



}
