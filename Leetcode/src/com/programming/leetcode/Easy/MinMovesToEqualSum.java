package com.programming.leetcode.Easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinMovesToEqualSum {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i : nums) min = i < min ? i : min;
        int res = 0;
        for(int i : nums) res += i-min;
        return res;
    }


    /* Math Logic:
    sum + m (n - 1) = x * n
    x = minNum + m
    sum + mn - m = (minNum + m) * n
    sum + mn - m = minNum * n + nm
    sum - minNum * n - m = 0
    sum - minNum * n = m
    */
    public int minMovesV2(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i : nums) {
            sum += i;
            min = Math.min(i, min);
        }
        return sum - (min * nums.length);
    }

    public static void main(String[] args) {
        MinMovesToEqualSum obj = new MinMovesToEqualSum();
        System.out.println(obj.minMoves(new int[]{1,2,3}));
        System.out.println(obj.minMovesV2(new int[]{1,2,3}));
    }
}
