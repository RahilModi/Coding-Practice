package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendarII {

    List<int[]> bookings;
    List<int[]> overlaps = new ArrayList<>();

    TreeMap<Integer, Integer> delta;

    public MyCalendarII() {
        bookings = new ArrayList<>();
        delta = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        for(int[] overlap_booking : overlaps){
            if(overlap_booking[0] < end && overlap_booking[1]>start) return false;
        }
        for(int [] booking : bookings){
            if(booking[0] < end && booking[1]> start){
                overlaps.add(new int[]{Math.max(booking[0], start), Math.min(booking[1],end)});
            }
        }
        bookings.add(new int[]{start,end});
        return true;
    }

    public boolean bookV2(int start, int end){
        delta.put(start, delta.getOrDefault(start,0)+1);
        delta.put(end, delta.getOrDefault(end,0)-1);
        int active = 0;
        for(Integer delta_time : delta.keySet()){ //improvement by replacing delta.keyset() with delta.values();
            active += delta.get(delta_time);
            if(active >= 3){
                delta.put(start, delta.get(start)-1);
                delta.put(end, delta.get(end)-1);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarII cal2 = new MyCalendarII();
        System.out.println(cal2.book(10,40));
        System.out.println(cal2.book(50,60));
        System.out.println(cal2.book(10,20));
        System.out.println(cal2.book(5,15));
        System.out.println(cal2.book(20,35));


        System.out.println(cal2.bookV2(10,40));
        System.out.println(cal2.bookV2(50,60));
        System.out.println(cal2.bookV2(10,20));
        System.out.println(cal2.bookV2(5,15));
        System.out.println(cal2.bookV2(20,35));
    }
}
