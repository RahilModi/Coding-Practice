package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OnlineElection {

    Map<Integer, Integer> map = new HashMap<>();
    int[] times;
    public OnlineElection(int[] persons, int[] times) {
        this.times= times;
        int lead = -1;
        int[] votes = new int[persons.length+1];
        for(int i =0; i < persons.length; i++){
            votes[persons[i]]++;
            if(i == 0 || votes[persons[i]] >= votes[lead]) lead = persons[i];
            map.put(times[i], lead);
        }
    }

    public int q(int t) {
        int i = Arrays.binarySearch(times, t);
        return i < 0 ? map.get(times[-i-2]) : map.get(times[i]);
    }
}
