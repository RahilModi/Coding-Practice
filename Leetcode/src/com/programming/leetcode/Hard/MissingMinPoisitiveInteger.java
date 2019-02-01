package com.programming.leetcode.Hard;

import java.util.Arrays;

public class MissingMinPoisitiveInteger {

    public int firstMissingPositive(int[] nums) {

        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 ) {
                if(j!=i) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                j++;
            }
        }
//        System.out.println(j);
//        System.out.println(Arrays.toString(nums));
        for(int i = j ; i < nums.length ; i++){
            if(j+Math.abs(nums[i])-1 < nums.length && nums[j+Math.abs(nums[i])-1] > 0){
                 nums[j+Math.abs(nums[i])-1] = -nums[j+Math.abs(nums[i])-1];
            }
        }
        int i = 0;
        for(; i+j < nums.length; i++){
            if(nums[i+j] > 0){
                break;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        MissingMinPoisitiveInteger obj = new MissingMinPoisitiveInteger();
        System.out.println(obj.firstMissingPositive(new int[]{1,1}));
        System.out.println(obj.firstMissingPositive(new int[]{3,8,-1,1,0}));
        System.out.println(obj.firstMissingPositive(new int[]{7,8,9,10,11}));
    }

}
