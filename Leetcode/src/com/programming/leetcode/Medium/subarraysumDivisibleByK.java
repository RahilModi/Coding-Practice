package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class subarraysumDivisibleByK {
    int resCount = 0;

    public int subarraysDivByKV1(int[] A, int K) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int prefix = 0, res = 0;
        for (int a : A) {
            prefix = (prefix + (a % K) + K) % K;
            res += count.getOrDefault(prefix, 0);
            count.put(prefix, count.getOrDefault(prefix, 0) + 1);
        }
        return res;
    }

    public int subarraysDivByK(int[] A, int K) {
        for(int i = 0; i < A.length; i++)
            helper(A, K, A[i], i+1);
        return resCount;
    }

    public void helper(int [] A, int K, int crt_sum, int crt_pos){
        if(crt_sum % K == 0){
            resCount++;
        }

        if(crt_pos != A.length){
            helper(A, K, crt_sum+A[crt_pos], crt_pos+1);
        }
    }

    public static void main(String[] args) {
        subarraysumDivisibleByK obj = new subarraysumDivisibleByK();
        System.out.println(obj.subarraysDivByKV1(new int[]{4,5,0,-2,-3,1},5));
        System.out.println(obj.subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
    }
}
