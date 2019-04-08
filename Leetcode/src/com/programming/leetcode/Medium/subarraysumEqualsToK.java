package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class subarraysumEqualsToK {

    //O(n)
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer,Integer> preSum =new HashMap<>();
        preSum.put(0,1);
        int sum =0, count = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(preSum.containsKey(sum-k)){
                count+=preSum.get(sum-k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
        }
        return count;
    }


    //O(n^2)
    public int subarraySumV1(int[] nums, int k){
        int [] sum = new int[nums.length+1];
        int count=0, crtsum;
        for(int start = 0; start < nums.length; start++){
            crtsum = 0;
            for (int end = start; end < nums.length; end++){
                crtsum += nums[end];
                if(crtsum == k) count++;
            }
        }
        return count;
    }

}
