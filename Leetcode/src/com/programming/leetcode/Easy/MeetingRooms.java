package com.programming.leetcode.Easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
//
//        For example,
//        Given [[0, 30],[5, 10],[15, 20]],
//        return false.
public class MeetingRooms {

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public boolean canAttendMeetings(Interval[] intervals) {

        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.start - b.start);

        for(Interval meeting: intervals){
            pq.add(meeting);
        }

        while(!pq.isEmpty()){
            Interval interval = pq.poll();
            if(!pq.isEmpty() && interval.end > pq.peek().start){
                return false;
            }
        }
        return true;
    }

    public boolean canAttendMeetingsV2(Interval[] intervals) {
        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        for (int i = 1; i < intervals.length; i++)
            if (intervals[i].start < intervals[i - 1].end)
                // found a conflict
                return false;

        return true;
    }

    public static void main(String[] args) {
        MeetingRooms obj = new MeetingRooms();
        Interval[] meetingTimes = {new Interval(0,30),new Interval(30,35),new Interval(35,45)};
        System.out.println(obj.canAttendMeetings(meetingTimes));
    }
}
