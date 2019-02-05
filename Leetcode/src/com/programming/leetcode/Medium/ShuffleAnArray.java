package com.programming.leetcode.Medium;

import java.util.Random;

public class ShuffleAnArray {

    int[] input, shuffled;
    Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        input = new int[nums.length];
        shuffled = new int[nums.length];
        System.arraycopy(nums,0,input,0,nums.length);
        System.arraycopy(nums,0,shuffled,0,nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        shuffled = input;
        input = input.clone();
        return input;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < input.length; i++){
            int pos = random.nextInt(input.length-i)+i;
            int temp = shuffled[i];
            shuffled[i]= shuffled[pos];
            shuffled[pos]=temp;
        }
        return shuffled;
    }


}
