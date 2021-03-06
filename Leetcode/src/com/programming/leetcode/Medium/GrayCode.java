package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] seen = new boolean[(int)Math.pow(2,n)];
        list.add(0);
        seen[0]=true;
        helper(res, list,n,seen,0);
        return res;
    }

    public void helper(List<Integer> result, List<Integer> l, int n, boolean[] seen, int last){
        if(l.size() == Math.pow(2,n)) {
            result.addAll(l);
            return;
        }

        //int last = l.get(l.size()-1);
        for(int i = 0; i < n; i ++) {
            int off = 1 << i;
            int c = last ^ off;
            if (seen[c]) continue;
            seen[c] = true;
            l.add(c);
            helper(result, l, n, seen,c);
            if (result.size() > 0) return;
        }
    }

    public List<Integer> grayCodeV1(int n) {
        List<Integer> res = new ArrayList<>();
        boolean[] seen = new boolean[(int)Math.pow(2,n)];
        res.add(0);
        seen[0] = true;
        backtrack(n, res, 0, seen);
        return res;
    }

    private boolean backtrack(int n, List<Integer> res, int last, boolean[] seen){
        if(res.size() == Math.pow(2,n)){
            return true;
        }
        for(int i = 0; i < n ; i++){
            int c = last ^ (1 << i);
            if(!seen[c]){
                seen[c] = true;
                res.add(c);
                if(backtrack(n, res, c, seen)){
                    return true;
                }
                seen[c] = false;
                res.remove(res.size()-1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        int n = 2;
        System.out.println(Arrays.toString(gc.grayCodeV1(n).toArray(new Integer[(int) Math.pow(2,n)])));
        n=3;
        System.out.println(Arrays.toString(gc.grayCode(n).toArray(new Integer[(int) Math.pow(2,n)])));
    }
}
