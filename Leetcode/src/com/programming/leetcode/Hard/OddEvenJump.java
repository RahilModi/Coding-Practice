package com.programming.leetcode.Hard;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {
    public int oddEvenJumps(int[] A) {
        int len =  A.length;
        boolean[] higher = new boolean[len], lower = new boolean[len];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        higher[len-1] = lower[len-1] = true;
        map.put(A[len-1], len-1);
        int steps = 1;
        for(int i = len-2; i >= 0 ; i--){
            Map.Entry hi = map.ceilingEntry(A[i]), lo = map.floorEntry(A[i]);
            if(hi!=null){
                higher[i] = lower[(int)hi.getValue()];
            }
            if(lo != null){
                lower[i] = higher[(int)lo.getValue()];
            }
            if(higher[i]) steps++;
            map.put(A[i],i);
        }
        return steps;
    }


    /*
    First let's create a boolean DP array.
    dp[i][0] stands for you can arrive index n - 1 starting from index i at an odd step.
    dp[i][1] stands for you can arrive index n - 1 starting from index i at an even step.
    Initialization:
    Index n - 1 is always a good start point, regardless it's odd or even step right now. Thus dp[n - 1][0] = dp[n - 1][1] = true.
    DP formula:
    dp[i][0] = dp[index_next_greater_number][1] - because next is even step
    dp[i][1] = dp[index_next_smaller_number][0] - because next is odd step
    Result:
    Since first step is odd step, then result is count of dp[i][0] with value true.
    CeilingEntry and FloorEntry reduces the logN queries compared to ceilingKey & floorKey.
     */
    public int oddEvenJumpsV1(int[] A) {
        if(A == null || A.length < 2) return A.length;
        int n = A.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean[][] dp = new boolean[n][2];
        dp[n - 1][0] = dp[n - 1][1] = true;
        map.put(A[n - 1], n - 1);
        int numWays = 1;

        for (int i = n - 2; i >= 0; i--) {
            // Odd step
            Map.Entry nextGreater = map.ceilingEntry(A[i]);
            if (nextGreater != null) {
                dp[i][0] = dp[(int)nextGreater.getValue()][1];
            }
            // Even step
            Map.Entry nextSmaller = map.floorEntry(A[i]);
            if (nextSmaller != null) {
                dp[i][1] = dp[(int)nextSmaller.getValue()][0];
            }
            map.put(A[i], i);
            numWays += dp[i][0] ? 1 : 0;
        }

        return numWays;
    }

    public static void main(String[] args) {
        OddEvenJump obj = new OddEvenJump();
        System.out.println(obj.oddEvenJumps(new int[]{10,13,12,14,15}));
    }
}
