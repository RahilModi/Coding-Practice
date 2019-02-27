package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), n, 2, res);
        return res;
    }

    public void dfs(List<Integer> crtFactors, int n, int start, List<List<Integer>> factors){
        for(int i = start; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                crtFactors.add(i);
                crtFactors.add(n/i);
                factors.add(new ArrayList<>(crtFactors));
                crtFactors.remove(crtFactors.size()-1);
                dfs(crtFactors,n/i, i, factors);
                crtFactors.remove(crtFactors.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombinations obj = new FactorCombinations();
        System.out.println(obj.getFactors(12));
    }
}
