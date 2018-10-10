package com.programming.leetcode.Easy;

public class RangeSumQuery {

    int[] dp;
    boolean isCached = false;

    public RangeSumQuery(int[] nums) {
        this.dp = new int[nums.length];
        populateSum(nums);
    }

    private void populateSum(int[] nums){
        if(isCached) return;
        int sum = 0;
        int index = 0;
        for(int num : nums){
            sum += num;
            this.dp[index++] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return i != 0 ? dp[j] - dp[i-1] : dp[j];
    }

    public static void main(String[] args) {
        RangeSumQuery obj = new RangeSumQuery(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0,2));
    }
}
