package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataStreamAsDisjointIntervals {

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    TreeMap<Integer, Interval> map;
    /** Initialize your data structure here. */
    public DataStreamAsDisjointIntervals() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) return;
        Map.Entry<Integer, Interval> lower = map.floorEntry(val);
        Map.Entry<Integer, Interval> upper = map.ceilingEntry(val);
        if (lower != null && upper != null && lower.getValue().end + 1 == val && upper.getKey() == val + 1) {
            map.get(lower.getKey()).end = map.get(upper.getKey()).end;
            map.remove(upper.getKey());
        } else if (lower != null && lower.getValue().end +1 >= val){
            map.get(lower.getKey()).end = Math.max(map.get(lower.getKey()).end, val);
        }else if (upper != null && upper.getKey() == val+1){
            map.put(val, new Interval(val,upper.getValue().end));
            map.remove(upper.getKey());
        }else{
            map.put(val,new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        DataStreamAsDisjointIntervals obj = new DataStreamAsDisjointIntervals();
        obj.addNum(6);
        obj.addNum(4);
        obj.addNum(8);
        obj.addNum(7);
        System.out.println(obj.getIntervals());
        obj.addNum(7);
        System.out.println(obj.getIntervals());
        obj.addNum(6);
        System.out.println(obj.getIntervals());
    }
}
