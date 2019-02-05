package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : C){
            for(int j : D){
                map.put(j+i, map.getOrDefault(j+i,0)+1);
            }
        }

        int res=0;
        for(int i : A){
            for(int j: B){
                res+=map.getOrDefault(-1 * (i+j),0);
            }
        }

        return res;

    }


}
