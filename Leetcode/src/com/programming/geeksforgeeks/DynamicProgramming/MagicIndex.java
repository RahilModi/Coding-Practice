package com.programming.geeksforgeeks.DynamicProgramming;

//Cracking the coding interview Chapter 8 : problem 3
public class MagicIndex {

    /*
        AN INDEX IS THE MAGIC IF A[I] == I
     */
    //O(N)
    int magicIndex(int [] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == i) return i;
        }
        return -1;
    }

    int magicIndexV1(int[] arr){
        return binarySearch(arr, 0, arr.length-1);
    }

    int binarySearch(int [] arr, int left, int right){
        while (left <= right){
            int mid = left + (right  - left)/2;
            if(arr[mid] == mid) return mid;
            else if(arr[mid] < mid) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }

    //NOw if an input contains the duplicate values..
    int magicIndexV2(int[] arr){
        return binarySearch(arr, 0, arr.length-1);
    }

    int binarySearchV1(int [] arr, int left, int right){
        if(left > right) return -1;
        int midIndex = left + (right - left)/2;
        int midVal = arr[midIndex];
        if(midVal == midIndex)return midIndex;
        int leftIndex = binarySearchV1(arr, left, Math.min(midIndex-1, midVal));
        if(leftIndex >= 0)return leftIndex;
        return binarySearchV1(arr, Math.max(midIndex+1, midVal), right);
    }

    public static void main(String[] args) {
        MagicIndex obj = new MagicIndex();
        System.out.println(obj.magicIndex(new int[]{-40,-20,-1,1,2,3,5,7,9,12,13}));
    }
}
