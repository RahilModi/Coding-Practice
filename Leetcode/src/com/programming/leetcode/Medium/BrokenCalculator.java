package com.programming.leetcode.Medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BrokenCalculator {

    public int brokenCalc(int X, int Y) {
        if(X == Y) return 0;
        int step = 0;
        while (Y > X){
            Y = (Y % 2 == 1) ? Y+1 : Y/2;
            step++;
        }
        return step + X - Y;
    }

    public int brokenCalcV1(int X, int Y) {
        if(X == Y) return 0;
        int step = 0;
        while (Y != X){
            if(X > Y) return (X-Y)+step;
            Y = (Y % 2 == 1) ? Y+1 : Y/2;
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        BrokenCalculator obj = new BrokenCalculator();
        System.out.println(obj.brokenCalcV1(1, 1000000000));
        System.out.println(obj.brokenCalc(2, 3));
        System.out.println(obj.brokenCalc(5, 8));
        System.out.println(obj.brokenCalc(3, 10));

    }

}
