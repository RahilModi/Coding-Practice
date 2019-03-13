package com.programming.leetcode.Medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            if(i >0 && nums[i] == nums[i-1])continue;
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                long sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }else if(sum > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return res;
    }


    public List<List<Integer>> isThreeSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            int newTarget = target-nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = i+1; j < nums.length; j++){
                if(map.containsKey(nums[j])){
                    int k= map.get(nums[j]);
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }else {
                    map.put(newTarget - nums[j], j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        System.out.println(obj.isThreeSum(new int[]{1,5,2,7,3,10,23,8},20));
    }
}
