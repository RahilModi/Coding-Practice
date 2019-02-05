package com.programming.leetcode.Medium;

public class IncreasingTriplets {

    public boolean increasingTriplet(int[] nums) {
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
        for(int i : nums){
            if(i <= num1) num1=i;
            else if(i <= num2) num2 = i;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplets obj = new IncreasingTriplets();
        System.out.println(obj.increasingTriplet(new int[]{1,2,3,4,5}));
    }
}
