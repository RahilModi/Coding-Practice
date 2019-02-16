package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UglyNumberII {

    //TLE
    public int nthUglyNumber(int n) {
        int crtVal = 1;
        while (n > 0) {
            int num = crtVal;
            for (int i : new int[]{2, 3, 5}) {
                while (num % i == 0) num /= i;
            }
            if (num == 1) {
                n--;
            }
            crtVal++;
        }
        return --crtVal;
    }

    /*
    https://leetcode.com/problems/ugly-number-ii/discuss/69362/O(n)-Java-solution
    The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
    because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:
    (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
    (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
    (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
     */
    public int nthUglyNumberV2(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int index2=0, index3=0, index5=0, factor_2=2, factor_3=3, factor_5=5;
        for(int i = 1; i<n; i++){
            int min_factor = Math.min(Math.min(factor_2,factor_3),factor_5);
            uglyNumbers[i] = min_factor;
            if(min_factor == factor_2){
                factor_2 = 2 * uglyNumbers[++index2];
            }
            if(min_factor == factor_3){
                factor_3 = 3 * uglyNumbers[++index3];
            }
            if(min_factor == factor_5){
                factor_5 = 5 * uglyNumbers[++index5];
            }
        }

        return uglyNumbers[n-1];
    }

    public int nthUglyNumberV3(int n) {
        if(n==1)return 1;
        PriorityQueue<Long> pq= new PriorityQueue<>();
        pq.add(1l);
        for(int i =1; i < n; i++){
            long temp = pq.poll();
            while (!pq.isEmpty() && pq.peek() == temp) temp = pq.poll();
            pq.add(temp*2);
            pq.add(temp*3);
            pq.add(temp*5);
        }
        return pq.poll().intValue();
    }


    public static void main(String[] args) {
        UglyNumberII obj = new UglyNumberII();
        System.out.println(obj.nthUglyNumberV3(10));
        System.out.println(obj.nthUglyNumberV2(10));
        System.out.println(obj.nthUglyNumber(10));
    }
}
