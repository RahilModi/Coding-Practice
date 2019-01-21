package com.programming.leetcode.Medium;

import java.util.*;

public class HandOfStraight {

    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) return false;

        TreeMap<Integer, Integer> sorted_map = new TreeMap<>();

        for(int i : hand) {
            if (sorted_map.containsKey(i)) {
                sorted_map.replace(i, sorted_map.get(i) + 1);
            } else {
                sorted_map.put(i, 1);
            }
        }

        while(sorted_map.size()>0){
            int first_entry = sorted_map.firstKey();
            for(int i = first_entry; i < first_entry+W; i++){
                Integer val = sorted_map.get(i);
                if(val == null) return false;
                if(val == 1) sorted_map.remove(i);
                else sorted_map.put(i, val-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HandOfStraight obj = new HandOfStraight();
        System.out.println(obj.isNStraightHand(new int[]{1,2,3,3,2,6,7,8,4},3));
        System.out.println(obj.isNStraightHand(new int[]{1,1,2,2,3,3},2));
    }
}
