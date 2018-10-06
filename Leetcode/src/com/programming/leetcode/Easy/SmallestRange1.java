package com.programming.leetcode.Easy;

public class SmallestRange1 {

    public int smallestRangeI(int[] A, int k) {

        int min = 0, max = 0;
        for(int i : A){
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        return Math.max(0, (max - k) - (min + k));

    }

    public static void main(String[] args) {

    }
}
