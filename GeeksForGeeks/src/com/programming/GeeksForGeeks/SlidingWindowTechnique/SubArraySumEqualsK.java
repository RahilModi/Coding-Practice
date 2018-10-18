package com.programming.GeeksForGeeks.SlidingWindowTechnique;

public class SubArraySumEqualsK {

    public boolean isSubArraySumEqualsK(int[] arr, int targetSum, int k){
        int window_sum = 0;
        for(int i = 0; i < k ; i++){
            window_sum += arr[i];
        }

        for(int i = k; i < arr.length; i++){
            if(window_sum == targetSum){
                return true;
            }else{
                window_sum += (arr[i] - arr[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SubArraySumEqualsK().isSubArraySumEqualsK(new int[]{ 1, 4, 2, 10, 2, 3, 1, 0, 20 }, 18, 4));
    }
}
