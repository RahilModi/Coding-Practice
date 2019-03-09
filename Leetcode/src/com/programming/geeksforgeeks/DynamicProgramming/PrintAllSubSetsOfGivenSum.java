package com.programming.geeksforgeeks.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllSubSetsOfGivenSum {


    public void findAllSubsetsofTargetT(int[] nums, int sum){
        Arrays.sort(nums);
        helper(nums, 0, sum, new ArrayList<>());
    }

    public void helper(int[] nums, int i, int sum, List<Integer> crt){
        if(i == nums.length && sum != 0 ) {
            return;
        }
        if(sum == 0){
            System.out.println(crt);
            return;
        }

        for(int index = i; index < nums.length; index++){
            if(nums[index] <= sum){
                crt.add(nums[index]);
                helper(nums, index+1, sum-nums[index],crt);
                crt.remove(crt.size()-1);
            }
        }
    }

    private void printAllSubsets(boolean[][] dp, int i, int sum, List<Integer> crt, int[] nums){
        if(sum ==0){
            System.out.println(crt);
            return;
        }
        if(dp[i-1][sum]){
            printAllSubsets(dp, i-1, sum, crt, nums);
        }

        if(sum >= nums[i-1] && dp[i-1][sum-nums[i-1]]){
            crt.add(nums[i-1]);
            printAllSubsets(dp, i-1, sum-nums[i-1], crt, nums);
            crt.remove(crt.size()-1);
        }
    }

    private void findAllSubSetsOfTargetSum(int[] nums, int sum){
        if(nums == null || nums.length == 0 || sum < 0) return;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        Arrays.sort(nums);

        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=sum ; j++)
            dp[i][j] = (nums[i-1] <= j)  ? dp[i-1][j] || dp[i-1][j-nums[i-1]] : dp[i-1][j];
        }
        if(!dp[n][sum])return;

        printAllSubsets(dp, n, sum, new ArrayList<>(), nums);

    }

    public static void main(String[] args) {
        PrintAllSubSetsOfGivenSum obj = new PrintAllSubSetsOfGivenSum();
        obj.findAllSubSetsOfTargetSum(new int[]{1,2,3,4,5,6},7);
        obj.findAllSubsetsofTargetT(new int[]{1,2,3,4,5,6},7);
    }
}
