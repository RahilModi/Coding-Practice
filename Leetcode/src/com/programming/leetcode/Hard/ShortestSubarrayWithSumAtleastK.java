package com.programming.leetcode.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtleastK {

    //NOT CORRECT SOLUTION FIRST INTUITION TO USE SLIDING WINDOW.....
    public int shortestSubarray(int[] A, int K) {
        if(A== null || A.length ==0) return -1;
        int sum = 0;
        int begin = 0, ptr = 0, min_len = Integer.MAX_VALUE;
        while (ptr < A.length){
            sum += A[ptr];
            while (sum >= K){
                min_len = Math.min(min_len, ptr+1-begin);
                sum -= A[begin++];
            }
            ptr++;
        }
        return min_len == Integer.MAX_VALUE ? -1 : min_len;
    }

    //https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C%2B%2BJavaPython-O(N)-Using-Deque
    /*
    Calculate prefix sum B of list A.
    B[j] - B[i] represents the sum of subarray A[i] ~ A[j-1]
    Deque d will keep indexes of increasing B[i].
    For every B[i], we will compare B[i] - B[d[0]] with K.

    Time Complexity:
    Loop on B O(N)
    Every index will be pushed only once into deque. O(N)
     */
    public int shortestSubarrayV1(int[] A, int K) {
        if(A== null || A.length ==0) return -1;
        int prefixSum[] = new int[A.length+1];
        int min_len = A.length+1;
        for(int i = 0; i < A.length; i++) prefixSum[i+1] = prefixSum[i] + A[i];
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i< prefixSum.length; i++){
            while (!queue.isEmpty() && prefixSum[i] - prefixSum[queue.peekFirst()] >= K){
                min_len = Math.min(min_len, i - queue.pollFirst());
            }
            while(!queue.isEmpty() && prefixSum[i] <= prefixSum[queue.peekLast()]) queue.pollLast();
            queue.offerLast(i);
        }
        return min_len <= A.length ? min_len : -1;
    }
    public static void main(String[] args) {
        ShortestSubarrayWithSumAtleastK obj = new ShortestSubarrayWithSumAtleastK();
        System.out.println(obj.shortestSubarrayV1(new int[]{84,-37,32,40,95},167));
        System.out.println(obj.shortestSubarray(new int[]{2,-1,2},3));
        System.out.println(obj.shortestSubarray(new int[]{1},1));
    }
}
