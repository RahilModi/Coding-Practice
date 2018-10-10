package com.programming.leetcode.Easy;

public class Sqrt {

    public int mySqrt(int x) {
        if(x < 2) return x;
        if(x == 2 || x == 3) return 1;
        int low = 1;
        int high = x/2;
        while(true){
            int mid = low + (high-low)/2;
            if(mid > x/mid) high = mid-1;
            else if((mid +1) > x/(mid+1)) return mid;
            else low = mid +1;
        }
    }


    public int mySqrtV2(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrtV2(25));
        System.out.println(new Sqrt().mySqrt(30));
        System.out.println(new Sqrt().mySqrt(36));
        System.out.println(new Sqrt().mySqrt(8));
        System.out.println(new Sqrt().mySqrt(3));
        System.out.println(new Sqrt().mySqrt(6));

    }
}
