package com.programming.leetcode.Medium;

import java.util.*;

public class MinimumIncrementToMakeUnique {

    public int minIncrementForUnique(int[] A) {
        TreeSet<Integer> uniqueSet = new TreeSet<>();
        int min = 0;
        List<Integer> notUniques = new ArrayList<>();
        for(int i : A){
            if(!uniqueSet.add(i)){
                notUniques.add(i);
            }
        }

        for(int i : notUniques){
            while (!uniqueSet.add(i)) {
                Integer ceilKey = uniqueSet.higher(i);
                if (ceilKey == null) i += 1;
                else {
                    if (ceilKey - i > 1) {
                        i += 1;
                    } else {
                        i = ceilKey;
                    }
                }
                min++;
            }
        }
        return min;
    }

    public int minIncrementForUniqueV1(int[] A) {
        Arrays.sort(A);
        int min = 0, prev = A[0];
        for(int i = 1; i <A.length;i++){
            int expected = prev+1;
            min += A[i] > expected ? 0 : expected - A[i];
            prev = Math.max(expected, A[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumIncrementToMakeUnique obj = new MinimumIncrementToMakeUnique();
        System.out.println(obj.minIncrementForUniqueV1(new int[]{3,2,1,2,1,7}));
        System.out.println(obj.minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }

}
