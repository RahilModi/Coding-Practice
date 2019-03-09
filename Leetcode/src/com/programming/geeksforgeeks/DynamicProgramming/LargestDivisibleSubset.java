package com.programming.geeksforgeeks.DynamicProgramming;

import java.util.Arrays;

//https://www.geeksforgeeks.org/largest-divisible-subset-array/
public class LargestDivisibleSubset {

    public void printLargestDivisibleSubset(int[] nums){

        Arrays.sort(nums);
        int n = nums.length;
        int[] divCount = new int[n];
        Arrays.fill(divCount, 1);
        int[] prevIndex = new int[n];
        Arrays.fill(prevIndex, -1);

        int maxIndex = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i]%nums[j] == 0 && (divCount[i] < divCount[j]+1)){
                    prevIndex[i] = j;
                    divCount[i] = divCount[j]+1;
                }
            }
            if(divCount[maxIndex] < divCount[i]) maxIndex = i;
        }
        int k = maxIndex;
        while (k>=0){
            System.out.println(nums[k] + " ");
            k = prevIndex[k];
        }
    }

    public static void main(String[] args) {
        LargestDivisibleSubset obj = new LargestDivisibleSubset();
        obj.printLargestDivisibleSubset(new int[]{1,4,2,4,6,8,16});
    }

}
