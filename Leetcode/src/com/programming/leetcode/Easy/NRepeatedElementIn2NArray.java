package com.programming.leetcode.Easy;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementIn2NArray {

    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        int index = 0;
        for(;index < A.length; index++){
            if (!set.add(A[index])) break;
        }
        return A[index];
    }

}
