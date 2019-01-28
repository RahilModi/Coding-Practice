package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;

public class MeetingRoomsII {

    SortedMap<Integer, Integer> bookings = new TreeMap<>();

    //Based on mycalendarII / mycalendarIII solutions -> use deltas
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        for(Interval interval : intervals){
            bookings.put(interval.start, bookings.getOrDefault(interval.start,0)+1);
            bookings.put(interval.end, bookings.getOrDefault(interval.end,0)-1);
        }

        int active = 0;
        int min_meeting_rooms = 0;
        for(int key : bookings.keySet()){
            active += bookings.get(key);
            min_meeting_rooms = Math.max(min_meeting_rooms,active);
        }
        return min_meeting_rooms;
    }

    //Using PriorityQueue
    public int minMeetingRoomsV1(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, (a,b) -> a.start - b.start);

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.end - b.end);

        //Add first interval in the min-heap
        pq.offer(intervals[0]);

        for(int i =1; i < intervals.length; i++){
            Interval interval = pq.poll();
            //if next interval start is earlier then the end of previous interval means there is an overlap between two meetings
            //so we need to add next interval in the min-heap
            if( intervals[i].start < interval.end){
                pq.offer(intervals[i]);
            }else{
                //if end is smaller or the same as next start of the meeting we will simply merge the interval by changing the end of the previous interval
                // [0,30], [35,50] => [0,50] and add that interval into the min-heap
                interval.end = intervals[i].end;
            }
            //if there is no overlap then size of heap will be 0
            //if there is overlap then heap size will remains non-zero and that is our answer.
            pq.offer(interval);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII obj = new MeetingRoomsII();
        Interval[] meetingTimes = {new Interval(0,30),new Interval(30,50),new Interval(60,90)};
        System.out.println(obj.minMeetingRooms(meetingTimes));
        System.out.println(obj.minMeetingRoomsV1(meetingTimes));
    }
}
