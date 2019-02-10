package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

//leetcode 904
public class FruitIntoBaskets {


    public int totalFruit(int[] tree) {
        Map<Integer,Integer> fruitType = new HashMap<>();
        int begin = 0, end = 0, max_len = 0;
        while(end < tree.length){
            int crt_fruit = tree[end];
            fruitType.put(crt_fruit,fruitType.getOrDefault(crt_fruit,0)+1);
            end++;
            while (fruitType.size()>2){
                int begin_type = tree[begin];
                fruitType.put(begin_type,fruitType.get(begin_type)-1);
                if(fruitType.get(begin_type)==0){
                    fruitType.remove(begin_type);
                }
                begin++;
            }
            max_len = Math.max(max_len,end-begin);
        }
        return max_len;
    }

    //https://leetcode.com/problems/fruit-into-baskets/discuss/170745/Problem%3A-Longest-Subarray-With-2-Elements
    public int totalFruitV1(int[] tree) {
        int crt = 0, res = 0, count_b = 0, a = 0, b = 0;

        for(int c : tree){
            crt = (c == a || c == b) ? crt + 1 : count_b +1;
            count_b = (c == b) ? count_b + 1 : 1;
            if(c!=b){
                a = b;
                b = c;
            }
            res = Math.max(res,crt);
        }
        return res;
    }



}
