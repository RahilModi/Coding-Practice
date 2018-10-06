package com.programming.leetcode.Medium;

public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {

        //System.out.println(nums[0]>>1);
        int totalCount = 0;
        int bitcount = 0;
        for(int i = 0; i < 32; i++){
            bitcount = 0;
            for(int n : nums){
                bitcount += (n>>i) & 1;
                //System.out.println((n>>i) & 1);
            }
            totalCount += (bitcount * (nums.length - bitcount));
        }
        return totalCount;
    }


    public int totalHammingDistanceV2(int[] nums){

        return 0;
    }

    public static void main(String[] args) {
        System.out.println( new TotalHammingDistance().totalHammingDistance(new int[]{5,14,2}));
    }
}
