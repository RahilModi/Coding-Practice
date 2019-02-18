package com.programming.leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class ContinuousSubArraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length <2) return false;
        for(int i = 0; i < nums.length; i++){
            int sum = nums[i];
            for(int  j = i+1; j < nums.length; j++){
                sum += nums[j];
                if(k==0 && sum == 0) return true;
                if(k!= 0 && sum % k == 0) return true;
            }
        }
        return false;
    }

    public boolean checkSubarraySumV1(int[] nums, int k) {
        if(nums == null || nums.length < 2) return false;
        if(k==0){
            for(int i = 1; i < nums.length ; i++){
                if(nums[i] ==0 && nums[i] == nums[i-1]) return true;
            }
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int i = 0; i < nums.length ;i++){
            sum = ((sum + nums[i]) % k);
            if(i > 0 && (sum == 0 || set.contains(sum))) return true;
            set.add(sum);
        }
        return false;
    }



    public static void main(String[] args) {
        ContinuousSubArraySum obj = new ContinuousSubArraySum();
        System.out.println(obj.checkSubarraySum(new int[]{23,2,4,6,7}, -6));
    }
}
