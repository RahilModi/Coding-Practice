package com.programming.leetcode.Medium;

public class SuperPow {

    private final static int mod = 1337;
    public int superPow(int a, int[] b) {
        return helper(a, b, b.length-1);
    }

    private int helper(int a, int[] b, int index){
        if(index < 0) return 1;
        return fastPow(helper(a, b, index-1),10) * fastPow(a, b[index])% mod;
    }

    private int fastPow(int a, int k){
        if(k==0) return 1;
        a%=mod;
        if((k&1)==1) return a*fastPow(a*a, k/2)%mod;
        else return fastPow(a*a, k/2)%mod;
    }

    public static void main(String[] args) {
        SuperPow obj = new SuperPow();
        System.out.println(obj.superPow(2, new int[]{1,0}));
    }


}
