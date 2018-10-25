package com.programming.leetcode.Easy;

import com.programming.leetcode.Medium.MapSum;

public class MaxDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int prev = -1, distance = 0;
        for(int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (prev == -1) distance = Math.max(distance, i - 0);
                else distance = Math.max(distance, (i - prev + 1) / 2);
                prev = i + 1;
            }
        }
        return Math.max(distance, seats.length - prev);
    }

    public static void main(String[] args) {
        System.out.println(new MaxDistanceToClosestPerson().maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
        System.out.println(new MaxDistanceToClosestPerson().maxDistToClosest(new int[]{1,0,1,1,1,1,1}));
        System.out.println(new MaxDistanceToClosestPerson().maxDistToClosest(new int[]{0,0,1}));
        System.out.println(new MaxDistanceToClosestPerson().maxDistToClosest(new int[]{0,0,0,0,1,0}));

        System.out.println(new MaxDistanceToClosestPerson().maxDistToClosest(new int[]{0,0,0,0,1,0,0,0,0,0,0}));
        System.out.println(new MaxDistanceToClosestPerson().maxDistToClosest(new int[]{1,0,0,0}));
    }

}
