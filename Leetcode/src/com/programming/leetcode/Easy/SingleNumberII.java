package com.programming.leetcode.Easy;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int onesSet = 0, twoesSet = 0;
        for(int n: nums){
            onesSet = (onesSet ^ n) & ~twoesSet;
            twoesSet = (twoesSet ^ n) & ~onesSet;
        }
        return onesSet;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
}
