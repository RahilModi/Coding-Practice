package com.programming.leetcode.Hard;

import java.util.Map;
import java.util.TreeMap;

public class RangeModule {

    TreeMap<Integer, Integer> intervals;
    public RangeModule() {
        intervals = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        if(start != null && intervals.get(start)>=left) left = start;
        if(end != null && intervals.get(end)> right) right = intervals.get(end);
        intervals.put(left, right);
        intervals.subMap(left, false, right, true).clear();
    }

    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        if(start == null) return false;
        return intervals.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        if(end != null && intervals.get(end)> right) intervals.put(right, intervals.get(end));
        if(start != null && intervals.get(start)>left) intervals.put(start, left);
        intervals.subMap(left, true,right, false).clear();
    }

    public static void main(String[] args) {
        RangeModule obj = new RangeModule();
        obj.addRange(10,14);
        obj.addRange(12,13);
        obj.queryRange(11,12);
        obj.removeRange(11,12);
    }
}
