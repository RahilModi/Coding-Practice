package com.programming.leetcode.Easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrime {

    public int countPrimes(int n) {

        boolean[] primes = new boolean[n];
        int count = 0;
        for(int i = 2 ; i < n ; i++){
            if(!primes[i]){
                count++;
                for(int j = 2 ; i*j < n ; j++){
                    primes[i*j] = true;
                }
            }
        }

        return count;

    }

    //time limit exceeds
    public int countPrimesv2(int n) {

        boolean[] primes = new boolean[n];
        int count = 0;
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i = 2 ; i < n ; i++){
            if(!primes[i]){
                boolean bPrime = false;
                for(int j : primeNumbers) {
                    if (i % j == 0) {
                        primes[i] = true;
                        bPrime = true;
                        break;
                    }
                }
                if(!bPrime) {
                    primeNumbers.add(i);
                    count++;
                }
            }
        }

        return count;

    }
    public static void main(String[] args) {
        System.out.println(new CountPrime().countPrimes(10));
        System.out.println(new CountPrime().countPrimesv2(10000));
    }

}
