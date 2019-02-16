package com.programming.leetcode.Medium;

import java.util.*;

public class SuperUglyNumbers {


    //Time Limit Exceeds...
    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Integer> primesInput = new HashSet<>();
        primesInput.add(1);
        Arrays.stream(primes).forEach(i -> primesInput.add(i));
        List<Integer> res = new ArrayList<>();
        int i = 1;
        while (res.size() < n){
            Set<Integer> primeFactors = primeFactorsOfNum(i);
            if(primesInput.containsAll(primeFactors)){
                res.add(i);
            }
            i++;
        }
        return res.get(n-1);
    }

    public Set<Integer> primeFactorsOfNum(int n){
        Set<Integer> res = new HashSet<>();
        res.add(1);
        for(int i = 2; i <= n ;i ++){
            while (n % i == 0){
                n /= i;
                res.add(i);
            }
        }
        return res;
    }

    //Based on nthUglyNumberII
    public int nthSuperUglyNumberV2(int n, int[] primes) {
        if(n==1)return 1;
        PriorityQueue<Long> pq= new PriorityQueue<>();
        pq.add(1l);
        for(int i =1; i < n; i++){
            long temp = pq.poll();
            while (!pq.isEmpty() && pq.peek() == temp) temp = pq.poll();
            for(int prime : primes){
                pq.add(temp*prime);
            }
        }
        return pq.poll().intValue();
    }

    public static void main(String[] args) {
        SuperUglyNumbers obj = new SuperUglyNumbers();
        System.out.println(obj.nthSuperUglyNumberV2(12, new int[]{2,7,13,19}));

        System.out.println(obj.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
    }
}
