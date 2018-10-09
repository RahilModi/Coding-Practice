package com.programming.leetcode.Medium;

import java.util.Random;

//Reservoir Sampling Technique
public class RandomPeakIndex {

    int[] mountains;
    Random random;

    public RandomPeakIndex(int[] nums) {
        this.mountains = nums;
        this.random = new Random();
    }

    public int pick(int target) {

        int count = 0;
        int result = -1;
        for(int i = 0; i < this.mountains.length; i++){
            if(this.mountains[i] != target) continue;
            else{
                if(random.nextInt(++count) == 0){
                    result = i;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new RandomPeakIndex(new int[]{1,2,3,3,3}).pick(1));
    }

}
