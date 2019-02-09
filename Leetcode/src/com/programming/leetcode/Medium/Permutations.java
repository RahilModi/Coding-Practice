package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        if(nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        permuteUtil(nums, res, new ArrayList<Integer>());
        return res;
    }

    private void permuteUtil(int[] input, List<List<Integer>> result, List<Integer> crt ){
        if(crt.size() == input.length){
            result.add(new ArrayList<>(crt));
        }else{
            for(int i = 0; i < input.length ; i++){
                if(crt.contains(input[i])) continue;
                crt.add(input[i]);
                permuteUtil(input,result,crt);
                crt.remove(crt.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        obj.permute(new int[]{1,2,3});
    }
}
