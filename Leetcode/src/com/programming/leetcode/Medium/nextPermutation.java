package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class nextPermutation {

    public void nextPermutation(int[] nums) {

        int i = nums.length -1;
        while(i > 0){
            if(nums[i] > nums[i-1]){
                break;
            }
            i--;
        }
        if(i != 0) {
            int index = nums.length - 1;
            int j = i - 1;
            while (index > j) {
                if (nums[index] > nums[j]) {
                    int t = nums[j];
                    nums[j] = nums[index];
                    nums[index] = t;
                    break;
                }
                index--;
            }
        }

        reverse(nums, i);

        print(nums);
    }

    private void reverse(int[] nums, int i){
        int left = i, right = nums.length -1;
        while(left < right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    private void print(int [] nums){
        for(int i : nums) System.out.print(i+ ", ");
    }


    public static void main(String[] args) {
        nextPermutation obj = new nextPermutation();
        obj.nextPermutation(new int[]{3,2,1});
        obj.nextPermutation(new int[]{1,2,3});
        obj.nextPermutation(new int[]{1,3,2});
        obj.nextPermutation(new int[]{2,3,1});
    }

}
