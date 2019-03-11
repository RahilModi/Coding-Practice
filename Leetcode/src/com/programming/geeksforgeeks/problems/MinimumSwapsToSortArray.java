package com.programming.geeksforgeeks.problems;

/*
Given an array containing sequence of bits (0 or 1), you have to sort this array in the ascending order i.e. all 0' in first part of array followed by all 1's. The constraints is that you can swap only the adjacent elements in the array. Find the minimum number of swaps required to sort the given input array.

Example: Given the array (0,0,1,0,1,0,1,1) the minimum number of swaps is 3.
 */
public class MinimumSwapsToSortArray {

    public int minimumSwaps(int[] arr){
        int swap = 0, count = 0;
        for(int j = arr.length-1; j >= 1; j--){
            if(arr[j] == 0) count++;
            else{
                swap += count;
            }
        }
        return swap;
    }

    public static void main(String[] args) {
        MinimumSwapsToSortArray obj = new MinimumSwapsToSortArray();
        System.out.println(obj.minimumSwaps(new int[]{0,1,0,1,0,0,1}));
    }
}
