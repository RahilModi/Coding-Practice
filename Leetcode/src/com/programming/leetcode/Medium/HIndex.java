package com.programming.leetcode.Medium;

public class HIndex {

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] buckets = new int[n];
        for(int c : citations){
            if(c >= n) buckets[n-1]++;
            else buckets[c]++;
        }
        int hIdx = 0, count = 0;
        for(int i = n-1; i>0;i--){
            count += buckets[i];
            if(count >= i) {
                hIdx = i;
                break;
            }
        }
        return hIdx;
    }

}
