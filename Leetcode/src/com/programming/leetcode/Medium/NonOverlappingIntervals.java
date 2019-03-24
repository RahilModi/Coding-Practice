package com.programming.leetcode.Medium;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length < 2) return 0;
        Arrays.sort(intervals, (a,b)->a.end - b.end);
        Interval crt = intervals[0];
        int count = 0;
        for(int i = 1; i<intervals.length; i++){
            if(crt.end <= intervals[i].start) {
                crt = intervals[i];
                count++;
            }
        }
        return intervals.length-count-1;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(1,2);
        intervals[1] = new Interval(2,3);
        intervals[2] = new Interval(1,3);
        intervals[3] = new Interval(3,4);

        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(intervals));
    }


}
