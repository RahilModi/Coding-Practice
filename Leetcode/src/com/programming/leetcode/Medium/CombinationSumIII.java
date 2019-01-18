package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, n, k, res, new ArrayList<Integer>());
        return res;
    }

    private void helper(int start, int n, int k, List<List<Integer>> res, List<Integer> crt_list){
        if(n == 0 && k == 0){
            List<Integer> crt = new ArrayList<>();
            crt.addAll(crt_list);
            res.add(crt);
            return;
        }
        if(n < 0 || k < 0) return;

        for(int i = start; i <= 9; i++){
            crt_list.add(i);
            helper(i+1, n-i, k-1, res, crt_list);
            crt_list.remove(crt_list.size()-1);
        }
    }

    public static void main(String[] args) {
        new CombinationSumIII().combinationSum3(3,7);
    }
}
