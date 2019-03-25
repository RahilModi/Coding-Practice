package com.programming.leetcode.Medium;

import com.programming.geeksforgeeks.DynamicProgramming.LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSet {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] divCount = new int[n], preIndex= new int[n];
        Arrays.fill(divCount,1);
        Arrays.fill(preIndex, -1);
        int maxIndex = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i]%nums[j] == 0 && divCount[i] < divCount[j]+1){
                    preIndex[i] = j;
                    divCount[i] = divCount[j]+1;
                }
            }
            if(divCount[maxIndex] < divCount[i]) maxIndex = i;
        }

        List<Integer> res = new ArrayList<>();
        while(maxIndex >= 0){
            res.add(nums[maxIndex]);
            maxIndex = preIndex[maxIndex];
        }
        return res;
    }

    public static void main(String[] args) {
        LargestDivisibleSet obj = new LargestDivisibleSet();
        System.out.println(obj.largestDivisibleSubset(new int[]{1,2,4,8}));
    }

}
