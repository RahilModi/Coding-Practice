package com.programming.leetcode.Medium;

import java.util.Random;

public class Random10UsingRandom7 {


    private int rand7(){
        return new Random().nextInt(8);
    }

    //NOTE: https://www.geeksforgeeks.org/generate-integer-from-1-to-7-with-equal-probability/

    public int rand10() {
        int x = 7*rand7() + rand7() - 7;
        if(x < 41)
            return (x % 10) + 1;
        return rand10();
    }


    public static void main(String[] args) {
        new Random10UsingRandom7().rand10();
    }
}
