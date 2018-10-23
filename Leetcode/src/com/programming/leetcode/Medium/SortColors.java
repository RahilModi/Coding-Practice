package com.programming.leetcode.Medium;

import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    //1-pass solution
    public void sortColorsV2(int[] nums) {
        int zeroIndex = 0, secondIndex = nums.length -1;
        for(int i = 0; i <= secondIndex ; i++){
            while(nums[i] == 2 && i < secondIndex){
                swap(nums, i, secondIndex);
                secondIndex--;
            }
            while(nums[i] == 0 && i > zeroIndex){
                swap(nums, i, zeroIndex);
                zeroIndex++;
            }
        }
    }

    //2-pass solution
    public void sortColorsV3(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            }
            if (nums[i] == 1) {
                count1++;
            }
            if (nums[i] == 2) {
                count2++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            } else if (i < count0 + count1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        new SortColors().sortColorsV2(new int[]{2,0,2,1,1,0});
    }
}
