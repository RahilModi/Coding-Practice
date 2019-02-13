package com.programming.leetcode.Hard;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDifferentIntegers {

    //TimeLimit Exceedss...
    public int subarraysWithKDistinct(int[] A, int K) {
        int ans=0;
        for(int i = 0; i < A.length - K+1; i++){
            int begin = i;
            Map<Integer,Integer> numFreq = new HashMap<>();
            int ptr = begin;
            while( ptr < A.length){
                if(numFreq.size() <= K || numFreq.containsKey(A[ptr])){
                    numFreq.put(A[ptr],numFreq.getOrDefault(A[ptr],0)+1);
                }
                ptr++;
                if(numFreq.size() == K){
                  ans++;
                }
                if(numFreq.size() > K) break;
            }
        }
        return ans;
    }


    public int subarraysWithKDistinctV1(int[] A, int K) {
        return subarraysWithAtMostK(A,K) - subarraysWithAtMostK(A,K-1);
    }


    public int subarraysWithAtMostK(int[] A, int K) {
        int ans=0;
        int begin = 0;
        Map<Integer,Integer> numFreq = new HashMap<>();
        int ptr = begin;
        while(ptr < A.length) {
            if(numFreq.getOrDefault(A[ptr], 0)==0) K--;
            numFreq.put(A[ptr], numFreq.getOrDefault(A[ptr],0)+1);
            while (K<0){
                int num = A[begin];
                numFreq.put(num, numFreq.get(num)-1);
                if(numFreq.get(num)==0) K++;
                begin++;
            }
            ans += ptr - begin +1;
            ptr++;
        }
        return ans;
    }


    public static void main(String[] args) {
        SubArraysWithKDifferentIntegers obj = new SubArraysWithKDifferentIntegers();
        System.out.println(obj.subarraysWithKDistinct(new int[]{1,2,1,3,4},3));
        System.out.println(obj.subarraysWithKDistinctV1(new int[]{1,2,1,3,4},3));
    }

}
