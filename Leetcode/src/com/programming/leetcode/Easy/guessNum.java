package com.programming.leetcode.Easy;

public class guessNum {

    public int guessNumber(int n) {
        int l = 1, h= n;
        while (l<=n) {
            int mid1 = l + (h - l) / 3;
            int mid2 = h - (h - l) / 3;
            int res1 = guess(mid1);
            if (res1 == 0) return mid1;
            int res2 = guess(mid2);
            if (res2 == 0) return mid2;
            else if (res1 < 0) h = mid1 - 1;
            else if (res2 > 0) l = mid2 + 1;
            else {
                l = mid1 + 1;
                h = mid2 - 1;
            }
        }
        return  -1;
    }

    //Implementation is not provided..
    private int guess(int num) {
        return  -1;
    }
}
