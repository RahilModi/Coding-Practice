package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersection {

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new Interval[] {};
        }

        List<Interval> res = new ArrayList<>();
        int j = 0, i = 0;
        Interval intervalB = null, intervalA = null;
        while (i < A.length && j < B.length){
            intervalA = A[i];
            intervalB = B[j];

            int startMax = Math.max(intervalA.start, intervalB.start);
            int endMin = Math.min(intervalA.end, intervalB.end);
            if(endMin >= startMax){
                res.add(new Interval(startMax, endMin));
            }
            if(intervalA.end == endMin) i++;
            if(intervalB.end == endMin) j++;
        }
        return res.toArray(new Interval[0]);

    }

    public static void main(String[] args) {
        Interval[] A = new Interval[]{new Interval(0,2),new Interval(5,10),new Interval(13,23),new Interval(24,25)};
        Interval[] B = new Interval[]{new Interval(1,2),new Interval(5,5),new Interval(8,10),new Interval(15,23),new Interval(24,24), new Interval(25,25)};
        IntervalListIntersection obj = new IntervalListIntersection();
        System.out.println(Arrays.toString(obj.intervalIntersection(A,B)));
    }

}
