package com.programming.leetcode.Easy;

public class PairsOfSongsDivisibleby60 {

    public int numPairsDivisibleBy60(int[] time) {
        int m = 60, count = 0, crtReminder = 0;
        int[] reminders = new int[60];
        for(int t : time){
            crtReminder = t%m;
            count+=reminders[(60-crtReminder)%60];
            reminders[crtReminder]++;
        }
        return count;
    }

    public static void main(String[] args) {
        PairsOfSongsDivisibleby60 obj = new PairsOfSongsDivisibleby60();
        System.out.println(obj.numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }

}
