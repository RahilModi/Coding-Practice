package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    static class Interval {
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

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if(newInterval == null) return intervals;
        if(intervals==null || intervals.size()==0){
            res.add(newInterval);
            return res;
        }
        if(newInterval.start <= intervals.get(0).start && newInterval.end >= intervals.get(intervals.size()-1).end){
            res.add(newInterval);
            return res;
        }
        boolean isMerged = false;
        for(int i = 0; i < intervals.size(); i++){
            Interval temp = intervals.get(i);
            int prev = i;
            if(!isMerged) {
                if(temp.start > newInterval.start && temp.start > newInterval.end){
                    res.add(newInterval);
                    isMerged = true;
                }else {
                    while (temp.end >= newInterval.start) {
                        isMerged = true;
                        temp.start = Math.min(temp.start, newInterval.start);
                        temp.end = Math.max(temp.end, newInterval.end);
                        prev = i;
                        if (i < intervals.size() - 1) {
                            newInterval = intervals.get(++i);
                        } else {
                            break;
                        }
                    }
                }
            }
            res.add(temp);
            i=prev;
        }
        if(!isMerged){
            res.add(newInterval);
        }
        return res;
    }

    public static void main(String[] args) {
        InsertInterval obj = new InsertInterval();
        List<Interval> test = new ArrayList<>();
        test.add(new Interval(1,2));
        test.add(new Interval(3,5));
        test.add(new Interval(6,7));
        test.add(new Interval(8,10));
        test.add(new Interval(13,16));

        System.out.println(Arrays.toString(obj.insert(test, new Interval(11,12)).toArray()));
    }
}
