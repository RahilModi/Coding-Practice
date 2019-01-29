package com.programming.leetcode.Medium;

/***
   * Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
   * to given total. Another variation is given an array is it possible to split it up into 2 equal
   * sum partitions. Partition need not be equal sized. Just equal sum.
   *
   * Time complexity - O(input.size * total_sum)
   * Space complexity - O(input.size*total_sum)
 */
public class SubsetSum {

    //https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubsetSum.java
    public boolean subsetSum(int[] arr, int target){
        boolean[][] dp = new boolean[arr.length+1][target+1];
        for(int i = 0; i<arr.length; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i <= arr.length; i++){
            for(int j = 1; j <= target; j++){
                if(j-arr[i] >= 0){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][target];
    }

    public boolean partition(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[][] T = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i <= arr.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - arr[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j - arr[i - 1]] || T[i - 1][j];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        return T[arr.length][sum];
    }

    public static void main(String args[]) {
        SubsetSum ss = new SubsetSum();
        int arr[] = {1, 3, 5, 5, 2, 1, 1, 6};
        System.out.println(ss.partition(arr));

        int arr1[] = {2, 3, 7, 8};
        System.out.print(ss.subsetSum(arr1, 11));

    }
}
