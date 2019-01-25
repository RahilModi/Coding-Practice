package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class SetMisMatch {

    public int[] findErrorNums(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        int dup = -1, missing = -1;
        for(int i = 1; i <= nums.length; i++){
            Integer val = map.get(i);
            if(val == null) missing = i;
            else if(val ==  2) dup = i;
        }
        return new int[]{dup, missing};
    }

    public int[] findErrorNumsUsingArray(int[] nums) {
        int[] arr = new int[nums.length];
        for(int n : nums){
            arr[n-1] += 1;
        }
        int dup = -1, missing = -1;
        for(int i = 0; i < nums.length; i++){
            if(arr[i] == 2) dup = i+1;
            else if(arr[i] == 0) missing = i+1;
        }
        return new int[]{dup, missing};
    }

    public int[] findErrorNumsNoExtraSpace(int[] nums) {
        int dup = -1, missing = -1;
        for(int n : nums){
            if(nums[Math.abs(n)-1]<0)
                dup = Math.abs(n);
            else
                nums[Math.abs(n)-1] *= -1;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) missing = i+1;
        }
        return new int[]{dup, missing};
    }


    public static void main(String[] args) {
        new SetMisMatch().findErrorNumsNoExtraSpace(new int[]{3,3,1});
    }

}
