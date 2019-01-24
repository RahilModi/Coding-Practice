package com.programming.leetcode.Easy;

import java.util.*;

public class LongestHarmoniousSequence {

    //Treemap gave slower performance due to logn insertion => overall nlogn
    //So use hashmap and then sort only keys => map insertion o(1) but sorting for k keys will be => klogk worst case it will be nlogn assuming all elements are unique.
    public int findLHS(int[] nums) {
        Map<Integer,Integer> mapNums = new HashMap<>();
        for(int i : nums){
            mapNums.put(i, mapNums.getOrDefault(i,0)+1);
        }
        Integer[] keys = mapNums.keySet().toArray(new Integer[mapNums.size()]);
        Arrays.sort(keys);
        int maxLHS = 0;
        for(int index = 1; index < keys.length; index++){
            if(keys[index] - keys[index-1] == 1){
                maxLHS = Math.max(maxLHS, mapNums.get(keys[index]) + mapNums.get(keys[index-1]));
            }
        }
        return maxLHS;
    }

    //Key point is when we need to check consecutive elements use +1 or -1 approach rather than performing comparision with all other input or sorting and checking adjacents
    //credits leetcode solutions
    public int findLHS_NoSorting(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }

    //Above solution uses two loops but we can reduce it to one loop using following
    //credits leetcode solutions
    public int findLHS_SingleLoop(int[] nums) {
        HashMap < Integer, Integer > map = new HashMap < > ();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1))
                res = Math.max(res, map.get(num) + map.get(num + 1));
            if (map.containsKey(num - 1))
                res = Math.max(res, map.get(num) + map.get(num - 1));
        }
        return res;
    }

}
