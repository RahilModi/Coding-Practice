package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

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

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> resultList = new ArrayList<>();
        for(Interval intervalInput: intervals) {
            boolean boverlapped =false;
            for (Interval interval : resultList) {
                if (interval.start < intervalInput.end && intervalInput.start < interval.end) {
                    interval.start = Math.min(interval.start, intervalInput.start);
                    interval.end = Math.max(interval.end, intervalInput.end);
                    boverlapped = true;
                    break;
                }
            }
            if(!boverlapped) resultList.add(intervalInput);
        }
        return resultList;
    }

    public List<Interval> mergeV2(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> resultList = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(int i = 1; i < intervals.size(); i++) {
            Interval intervalInput = intervals.get(i);
            if (intervalInput.start <= end) {
                end = Math.max(end, intervalInput.end);
                start = Math.min(start, intervalInput.start);
            }else {
                resultList.add(new Interval(start, end));
                start = intervalInput.start;
                end = intervalInput.end;
            }
        }
        resultList.add(new Interval(start, end));
        return resultList;
    }

    //Similar to meeting roomsII problem
    public List<Interval> mergeV3(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.size(), (a,b) -> a.start-b.start);
        for(Interval interval : intervals){
            pq.offer(interval);
        }
        while(pq.size() > 1){
            Interval i1 = pq.poll();
            Interval i2 = pq.poll();
            if(i1.end >= i2.start){
                pq.offer(new Interval(i1.start, Math.max(i1.end, i2.end)));
            }else{
                res.add(i1);
                pq.offer(i2);
            }
        }
        res.add(pq.poll());
        return res;
    }

}
