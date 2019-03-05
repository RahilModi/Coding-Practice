package com.programming.leetcode.Medium;

import java.util.Arrays;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {

        int[] res = new int[target+1];
        Arrays.sort(nums);
        res[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int n : nums){
                if(i-n >= 0){
                    res[i] += res[i-n];
                }else{
                    break;
                }
            }
        }
        return res[target];

    }

    public static void main(String[] args) {
        CombinationSumIV obj = new CombinationSumIV();
        System.out.println(obj.combinationSum4(new int[]{1,2,3},4));
    }
}
