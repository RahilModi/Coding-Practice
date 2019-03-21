package com.programming.leetcode.Hard;

public class NthMagicalNumber {

    private long gcd(long a, long b){
        return a==0? b : gcd(b%a, a);
    }

    public int nthMagicalNumber(int N, int A, int B) {
        long a = A, b = B, l = 2, r = (long)1e14, mod = (long) 1e9+7, mid, GCD = gcd(a,b), LCM = (a*b)/GCD;
        while (l < r){
            mid = l + (r - l)/2;
            if(mid/A + mid/B - mid/LCM < N) l = mid + 1;
            else r = mid;
        }
        return (int)(l%mod);
    }

    public static void main(String[] args) {
        NthMagicalNumber obj =new NthMagicalNumber();
        System.out.println(obj.nthMagicalNumber(5,2, 4));
    }



}
