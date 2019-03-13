package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int index, int[] nums, int sum, List<Integer> crt, List<List<Integer>> res){
        if(sum == 0){
            res.add(new ArrayList<>(crt));
            return;
        }
        if(sum < 0) return;
        for(int i = index; i<nums.length; i++){
            crt.add(nums[i]);
            backtrack(i, nums, sum-nums[i], crt, res);
            crt.remove(crt.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,7},7));
    }
}
