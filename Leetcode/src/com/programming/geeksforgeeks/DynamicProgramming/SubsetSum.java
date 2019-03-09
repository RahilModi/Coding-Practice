package com.programming.geeksforgeeks.DynamicProgramming;


//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
//https://www.geeksforgeeks.org/subset-sum-problem-osum-space/
public class SubsetSum {

    public boolean isSubsetSum(int[] nums, int pos, int sum){
        if(sum == 0) return true;
        if(pos == 0 && sum != 0) return false;
        if(nums[pos-1] > sum) return isSubsetSum(nums, pos-1, sum);
        return isSubsetSum(nums, pos-1, sum) || isSubsetSum( nums, pos-1, sum-nums[pos-1]);
    }

    //O(n*sum) space
    public boolean isSubsetSumDP(int[] nums, int sum){
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for(int i = 0; i <=nums.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= nums.length; i++){
            for(int j =1; j <= sum; j++){
                if(j<nums[i-1]) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[nums.length][sum];
    }

    //O(2*sum) space = O(sum) space
    public boolean isSubsetSumDPV1(int[] nums, int sum){
        boolean[][] dp = new boolean[2][sum+1];

        for(int i = 0; i <= nums.length; i++){
            for(int j =0; j <= sum; j++){
                if(j == 0) dp[i%2][j] = true;
                else if(i == 0) dp[i%2][j] = false;
                else if(j<nums[i-1]) dp[i%2][j] = dp[(i+1)%2][j];
                else{
                    dp[i%2][j] = dp[(i+1)%2][j] || dp[(i+1)%2][j-nums[i-1]];
                }
            }
        }

        return dp[nums.length%2][sum];
    }

    public boolean isSubSetSumDPV2(int[] nums, int sum){
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int num : nums){
            for(int j = sum; j > 0 ;j --){
                if(j >= num){
                    dp[j] = dp[j] || dp[j-num];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        SubsetSum obj = new SubsetSum();
        System.out.println(obj.isSubsetSumDPV1(new int[]{1,4,6,19,20,13,8},5));
        System.out.println(obj.isSubSetSumDPV2(new int[]{4,6,19,20,13,8},5));
    }



}
