package com.programming.leetcode.Easy;

public class PaintFence {

    public int numWays(int n, int k) {
        if(n == 0 )return 0;
        if(n == 1) return k;
        int sameColors=k;
        int differentColors=k*(k-1);
        for(int i = 2; i <n; i++){
            int prevDiff = differentColors;
            differentColors = (differentColors + sameColors) * k-1;
            sameColors = prevDiff;
        }
        return sameColors + differentColors;
    }
}
