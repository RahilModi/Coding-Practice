package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class HasGroupSizeX {

    public boolean hasGroupsSizeX(int[] deck) {

        Map<Integer,Integer> num =new HashMap<>();
        for(int i : deck){
            num.put(i, num.getOrDefault(i,0)+1);
        }
        int res = 0;
        for(int i : num.values()){
            res = gcd(i,res);
        }
        return res>1;
    }

    private int gcd(int a, int b){
        return a==0? b : gcd(b%a, a);
    }

    public static void main(String[] args) {
        new HasGroupSizeX().hasGroupsSizeX(new int[]{1,2,3,2,1,3,1,3});
    }
}
