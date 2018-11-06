package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Bookings{
    int startTime;
    int endTime;

    public Bookings(int start, int end){
        this.startTime = start;
        this.endTime = end;
    }
}

public class MyCalendar{

    List<Bookings> bookings;

    TreeMap<Integer,Integer> bookingsSorted;

    public MyCalendar() {
        bookings = new ArrayList<>();
        bookingsSorted = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (bookings.size() != 0) {
            for(Bookings b : bookings){
                if(start < b.endTime && b.startTime < end){
                    return false;
                }
            }
        }
        Bookings obj = new Bookings(start, end);
        bookings.add(obj);
        return true;
    }

    TreeMap<Integer, Integer> temp = new TreeMap<>();
    public boolean bookV1(int start, int end){
        Integer previousStartTime = bookingsSorted.floorKey(start);
        Integer nextStartTime = bookingsSorted.ceilingKey(start);

        if((previousStartTime == null || bookingsSorted.get(previousStartTime) <= start) && (nextStartTime == null || end <= nextStartTime)){
            bookingsSorted.put(start, end);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCalendar cal = new MyCalendar();
        System.out.print(cal.book(10,20));
        System.out.print(cal.book(15, 25));
        System.out.print(cal.book(20,30));
        System.out.print(cal.book(5,10));
        System.out.print(cal.book(6,14));
        System.out.print(cal.book(6,40));
        System.out.print(cal.book(40,50));
        System.out.print(cal.book(30,35));
        System.out.print(cal.book(35,37));
        System.out.print(cal.book(1,50));
        System.out.print(cal.book(10,19));
        System.out.print(cal.book(4,45));
        System.out.print(cal.book(17,50));

        System.out.println();
        System.out.print(cal.bookV1(10,20));
        System.out.print(cal.bookV1(15, 25));
        System.out.print(cal.bookV1(20,30));
        System.out.print(cal.bookV1(5,10));
        System.out.print(cal.bookV1(6,14));
        System.out.print(cal.bookV1(6,40));
        System.out.print(cal.bookV1(40,50));
        System.out.print(cal.bookV1(30,35));
        System.out.print(cal.bookV1(35,37));
        System.out.print(cal.bookV1(1,50));
        System.out.print(cal.bookV1(10,19));
        System.out.print(cal.bookV1(4,45));
        System.out.print(cal.bookV1(17,50));
    }

}
