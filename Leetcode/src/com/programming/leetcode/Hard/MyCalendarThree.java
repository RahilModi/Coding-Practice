package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarThree {

    List<int[]> bookings;

    TreeMap<Integer, Integer> delta;

    int maxOverlappedBookings = 1;

    public MyCalendarThree() {
        bookings = new ArrayList<>();
        delta = new TreeMap<>();
    }

    public int book(int start, int end) {
        int crt_overlap = 1;
        for(int [] booking : bookings){
            if(booking[0] < end && booking[1]> start){
                crt_overlap++;
            }
        }
        bookings.add(new int[]{start,end});
        maxOverlappedBookings = Math.max(maxOverlappedBookings, crt_overlap);
        return maxOverlappedBookings;
    }

    public int bookV2(int start, int end){
        delta.put(start, delta.getOrDefault(start,0)+1);
        delta.put(end, delta.getOrDefault(end,0)-1);
        int active = 0;
        for(Integer delta_times : delta.values()){ //improvement by replacing delta.keyset() with delta.values();
            active += delta_times;
            maxOverlappedBookings = Math.max(maxOverlappedBookings, active);
        }
        return maxOverlappedBookings;
    }

    public static void main(String[] args) {
        MyCalendarThree cal3 = new MyCalendarThree();
        System.out.println(cal3.book(10,20));
        System.out.println(cal3.book(50,60));
        System.out.println(cal3.book(10,40));
        System.out.println(cal3.book(5,15));
        System.out.println(cal3.book(5,10));
        System.out.println(cal3.book(25,55));

        cal3.maxOverlappedBookings=1;
        System.out.println(cal3.bookV2(10,20));
        System.out.println(cal3.bookV2(50,60));
        System.out.println(cal3.bookV2(10,40));
        System.out.println(cal3.bookV2(5,15));
        System.out.println(cal3.bookV2(5,10));
        System.out.println(cal3.bookV2(25,55));
    }

}
