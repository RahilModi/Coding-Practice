package com.programming.leetcode.Medium;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class lengthOfLongestIncreasingFibonaci {

    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int x : A)set.add(x);
        int id = 0, ans = 0;
        for(int i : A){
            for(int j = id+1; j < A.length-1;j++){
                int y = A[j];
                int z = i + y;
                int length = 2;
                while(set.contains(z)){
                    int temp = z;
                    z += y;
                    y = temp;
                    ans = Math.max(ans, ++length);
                }
            }
            id++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new lengthOfLongestIncreasingFibonaci().lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
    }
}
