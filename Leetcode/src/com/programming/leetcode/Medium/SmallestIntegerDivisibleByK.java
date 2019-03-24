package com.programming.leetcode.Medium;

//Integer should only contains 1
public class SmallestIntegerDivisibleByK{

    /*
    Given a positive integer K, you need find the smallest positive integer N such that N is divisible by K, and N only contains the digit 1.
    Return the length of N.  If there is no such N, return -1.
     */
    //Time = O(K)
    public int smallestRepunitDivByK(int K) {
        if(K%2 == 0 || K%5 == 0) return -1;
        int crtNum = 0;
        for(int N = 1; N <= K; N++){
            crtNum =  ((crtNum * 10) + 1) % K;
            if(crtNum == 0) return N;
        }
        return -1;
    }

    public static void main(String[] args) {
        SmallestIntegerDivisibleByK obj = new SmallestIntegerDivisibleByK();
        System.out.println(obj.smallestRepunitDivByK(9));
        System.out.println(obj.smallestRepunitDivByK(2));
        System.out.println(obj.smallestRepunitDivByK(3));
    }
}
