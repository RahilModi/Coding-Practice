package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int window_sum = 0, countSubArray=0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length;j++){
                window_sum += nums[j];
                if(window_sum == k) {
                    countSubArray++;
                }
            }
            window_sum = 0;
        }
        return countSubArray;
    }

    public int subarraySumV2(int[] nums, int k) {
        int sum = 0, countSubArray=0;
        Map<Integer,Integer> sumMap= new HashMap<>();
        sumMap.put(0,1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sumMap.containsKey(sum-k)) countSubArray += sumMap.get(sum-k);
            sumMap.put(sum, sumMap.getOrDefault(sum,0)+1);
        }
        return countSubArray;
    }

    public static void main(String[] args) {
        System.out.println(new CountOfSubArraySumEqualsK().subarraySumV2(new int[]{2,3,4,5,6,7,1,23,21,3,1,2,1,1,1,1,1,12,2,3,2,3,2,2}, 2));
        System.out.println(new CountOfSubArraySumEqualsK().subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0}, 0));
    }


}
