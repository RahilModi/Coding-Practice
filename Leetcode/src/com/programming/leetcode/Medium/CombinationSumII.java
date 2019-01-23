package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, 0,target);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int start, int target){
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0) return;

        for(int i = start; i < candidates.length; i++){
            if(i >start && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            helper(res,temp,candidates,i+1,target-candidates[i]);
            temp.remove(temp.size()-1);
        }
    }


    public static void main(String[] args) {
        CombinationSumII obj = new CombinationSumII();
        for(List<Integer> t : obj.combinationSum2(new int[]{10,1,2,7,6,1,5},8)){
            System.out.println(Arrays.toString(t.toArray()));
        }
    }
}
