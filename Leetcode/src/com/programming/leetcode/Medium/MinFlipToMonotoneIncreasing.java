package com.programming.leetcode.Medium;

public class MinFlipToMonotoneIncreasing {

    //not working for all type of input when flapping both some 1's and some 0's are causing issue.
    public int minFlipsMonoIncr(String S) {
        if(S==null||S.length() == 0) return 0;
        int firstPosofOne = Integer.MIN_VALUE, lastPosofOne = Integer.MAX_VALUE, numberOfzerosAfterFirstOne=0;
        int lastPosofZero = 0;
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(c=='1') {
                if(firstPosofOne == Integer.MIN_VALUE)
                    firstPosofOne = lastPosofOne= i;
                else
                    lastPosofOne = i;
            }
            else {
                if(firstPosofOne >= 0)
                    numberOfzerosAfterFirstOne++;
                lastPosofZero=i;
            }
        }
        int num_zeros_after_last_one =0;
        if(lastPosofZero != S.length()-1) {
            lastPosofOne = lastPosofZero;
        }else{
            num_zeros_after_last_one = S.length()-lastPosofOne-1;
        }
        if(firstPosofOne == Integer.MIN_VALUE) return 0;
        return Math.min(lastPosofOne-firstPosofOne+1-(numberOfzerosAfterFirstOne-num_zeros_after_last_one),numberOfzerosAfterFirstOne);
    }

    //Works for all types of input..copied from discussion...
    public int minFlipsMonoIncrV1(String S) {
        if (S == null || S.length() == 0) return 0;
        int num_flips = 0, num_ones = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '1') {
                num_ones++;
            } else {
                if (num_ones == 0) continue;
                else
                    num_flips++;
            }
            num_flips = Math.min(num_flips,num_ones);
        }
        return num_flips;
    }

    public static void main(String[] args) {
        MinFlipToMonotoneIncreasing obj = new MinFlipToMonotoneIncreasing();
        System.out.println(obj.minFlipsMonoIncrV1("10011111110010111011"));
        System.out.println(obj.minFlipsMonoIncr("00110"));
        System.out.println(obj.minFlipsMonoIncr("00011000"));
        System.out.println(obj.minFlipsMonoIncr("010110"));
        System.out.println(obj.minFlipsMonoIncr("0011111"));
        System.out.println(obj.minFlipsMonoIncr("1111111"));
        System.out.println(obj.minFlipsMonoIncr("00000000"));
        System.out.println(obj.minFlipsMonoIncr("1111001111"));
        System.out.println(obj.minFlipsMonoIncr("0101100011"));

    }
}
