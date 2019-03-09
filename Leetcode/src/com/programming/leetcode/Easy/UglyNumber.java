package com.programming.leetcode.Easy;

public class UglyNumber {
    public boolean isUglyNumber(int num) {
        if(num == 0) return false;
        for(int n : new int[]{2,3,5}){
            while (num % n == 0) num/=n;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        UglyNumber obj = new UglyNumber();
        System.out.println(obj.isUglyNumber(6));
        System.out.println(obj.isUglyNumber(7));
    }
}
