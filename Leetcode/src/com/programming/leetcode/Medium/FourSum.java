package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++){
            if(nums[i] + nums[i+1]+ nums[i+2]+nums[i+3] > target) break;
            if(nums[i] + nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3] < target) continue;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length-2; j++){
                if(nums[j] + nums[i+1]+ nums[i+2] > (target - nums[i])) break;
                if( nums[j]+nums[nums.length-1]+nums[nums.length-2] < target - nums[i]) continue;
                if(j >i+1 && nums[j] == nums[j-1]) continue;
                int low = j + 1, high = nums.length-1;
                while(low < high){
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }else if(sum > target){
                        high--;
                    }else{
                        low++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }


}
