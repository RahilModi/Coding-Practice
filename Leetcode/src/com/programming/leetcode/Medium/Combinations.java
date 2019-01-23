package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combinations_helper(n, k, res, new ArrayList<>(), 1);
        return res;
    }

    public void combinations_helper(int n, int k, List<List<Integer>> res, List<Integer> crt, int pos){
        if(crt.size() == k){
            res.add(new ArrayList<>(crt));
            return;
        }

        for( int i = pos; i <= n; i++){
            crt.add(i);
            combinations_helper(n, k, res,crt,i+1);
            crt.remove(crt.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        for(List<Integer> l : c.combine(4,2)){
            System.out.println(Arrays.toString(l.toArray(new Integer[l.size()])));
        }
    }
}
