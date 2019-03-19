package com.programming.leetcode.Medium;

import java.util.*;

public class DoublePairs {

    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        List<Integer> res = new ArrayList<>(map.keySet());
        Collections.sort(res);
        for(int i : res){
            if (i!=0 && map.get(i) > 0) {
                int want = 2 * i;
                if(i < 0){
                    if(i%2 != 0) return false;
                    else want = i/2;
                }

                if(map.getOrDefault(want, 0) < map.get(i)) return false;
                else {
                    map.put(want, map.get(want) - map.get(i));
                    map.put(i, 0);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DoublePairs obj = new DoublePairs();
        System.out.println(obj.canReorderDoubled(new int[]{-6,-3}));
        System.out.println(obj.canReorderDoubled(new int[]{10,20,40,80}));
        System.out.println(obj.canReorderDoubled(new int[]{3,1,3,6}));
        System.out.println(obj.canReorderDoubled(new int[]{-4,4,2,-2}));
        System.out.println(obj.canReorderDoubled(new int[]{1,2,4,16,8,4}));
    }

}
