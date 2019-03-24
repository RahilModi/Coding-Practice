package com.programming.leetcode.Hard;

import java.util.Arrays;

public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        //If input is unsorted we need to sort first ..but here input is sorted..
        //[0,sum) can be made initially now if input[i] <= sum means we can make sum = sum + nums[i] and now increment i by 1
        //new [0, prevSum + nums[i]) if next input is greater than our crtsum means we need to patch a value hence increment counter by 1 and our patch element should be crtSum.
        long sum = 1;
        int patches = 0, i = 0;
        while (sum <= n){
            if( i < nums.length && nums[i] <= sum){
                sum += nums[i];
                i++;
            }else{
                sum += sum;
                patches++;
            }
        }
        return patches;
    }

    public int minPatchesV1(int[] nums, int n) {
         int patches, i;
         patches = i = 0;
         long preSum = 0;
         while (preSum < n){
             if(i >= nums.length || nums[i] > preSum+1){
                 patches++;
                 preSum += preSum+1;
             }else{
                 preSum += nums[i];
                 i++;
             }
         }
         return patches;
    }

    public static void main(String[] args) {
        PatchingArray obj = new PatchingArray();
        System.out.println(obj.minPatchesV1(new int[]{1,2,31,33},Integer.MAX_VALUE));
        System.out.println(obj.minPatches(new int[]{1,2,31,33},Integer.MAX_VALUE));
    }

}
