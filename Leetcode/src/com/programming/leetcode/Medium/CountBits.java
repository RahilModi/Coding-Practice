package com.programming.leetcode.Medium;

public class CountBits {

    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 1; i <= num; i++){
            res[i] =res[i/2] + (i%2);
        }
        return res;
    }
}
