package com.programming.leetcode.Easy;

import java.util.*;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> numsIndex = new HashMap<>();
        int i = 0;
        for(int num : nums) numsIndex.put(num, i++);

        Arrays.sort(nums);
        String [] result =  new String[nums.length];
        for(int index = nums.length - 1; index >= 0; index--){
            int resultIndex = numsIndex.get(nums[index]);
            if(index == nums.length - 1) result[resultIndex] = "Gold Medal";
            else if(index == nums.length - 2) result[resultIndex] = "Silver Medal";
            else if(index == nums.length - 3) result[resultIndex] = "Bronze Medal";
            else result[resultIndex] = nums.length - index + "";
        }
        return result;
    }


    public static void main(String[] args) {
        for(String str: new RelativeRanks().findRelativeRanks(new int[]{5, 4, 3, 2, 1})){
            System.out.println(str);
        }
    }
}
