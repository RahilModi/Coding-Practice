package com.programming.leetcode.Medium;

import java.util.TreeMap;

public class FindRightInterval {

    public int[] findRightInterval(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0];
        int[] res = new  int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int id = 0;
        for(Interval interval : intervals){
            map.put(interval.start, id++);
        }
        id = 0;
        for(Interval interval : intervals){
            Integer key = map.ceilingKey(interval.end);
            if(key == null){
                res[id++] = -1;
            }else{
                res[id++] = map.get(key);
            }
        }
        return res;
    }
}
