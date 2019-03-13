package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack( nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> crt, List<List<Integer>> res, boolean[] visited){
        if(crt.size() == nums.length){
            res.add(new ArrayList<>(crt));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(visited[i] || i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            crt.add(nums[i]);
            backtrack(nums, crt, res, visited);
            crt.remove(crt.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationII obj = new PermutationII();
        System.out.println(obj.permuteUnique(new int[]{1,1,2}));
    }
}
