package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for(int i = 0; i < B.length; i++) pq.offer(new int[]{B[i],i});
        int[] res = new int[A.length];
        int lo = 0, hi = A.length-1;
        while (!pq.isEmpty()){
            int[] crt = pq.poll();
            if(A[hi] > crt[0]) res[crt[1]] = A[hi--];
            else res[crt[1]] = A[lo++];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new AdvantageShuffle().advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11}));
    }
}
