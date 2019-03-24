package com.programming.leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORofSubArrays {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>(), pre = new HashSet<>(), crt = new HashSet<>();
        for(int x : A){
            crt=new HashSet<>();
            crt.add(x);
            for(int c : pre){
               crt.add(c | x);
            }
            pre = crt;
            res.addAll(pre);
        }
        return res.size();
    }

    public static void main(String[] args) {

        BitwiseORofSubArrays obj = new BitwiseORofSubArrays();
        System.out.println(obj.subarrayBitwiseORs(new int[]{1,3,2}));
    }
}
