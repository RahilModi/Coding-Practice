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

    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        int n = 2;
        System.out.println(Arrays.toString(gc.grayCode(n).toArray(new Integer[(int) Math.pow(2,n)])));
        n=3;
        System.out.println(Arrays.toString(gc.grayCode(n).toArray(new Integer[(int) Math.pow(2,n)])));
    }
}
