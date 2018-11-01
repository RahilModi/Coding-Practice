package com.programming.leetcode.Medium;

import java.util.Arrays;

public class JumpGame {


    int[] dp;

    public boolean canJump(int[] nums) {
        return jumpHelper(0, nums);
    }

    private boolean jumpHelper(int index, int[] nums){
        if(index == nums.length -1) return true;
        int maxPosReach = Math.min(index + nums[index], nums.length -1);
        for(int pos = index+1; pos <= maxPosReach; pos++){
            if(jumpHelper(pos, nums)) return true;
        }
        return false;
    }

    public boolean canJumpWithDP(int[] nums) {
        dp = new int[nums.length];
        dp[nums.length-1] = 1;
        return jumHelperUsingDP(0, nums);
    }

    private boolean jumHelperUsingDP(int index, int[] nums){
        if(dp[index] != 0){
            return dp[index]==1? true : false;
        }
        int maxPosReach = Math.min(index + nums[index], nums.length -1);
        for(int pos = index+1; pos <= maxPosReach; pos++){
            if(jumHelperUsingDP(pos, nums)){
                dp[pos] = 1;
                return true;
            }
        }

        dp[index] = -1;
        return false;
    }


    public boolean canJumpWithBottomUp(int[] nums) {
        dp = new int[nums.length];
        dp[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--) {
            int maxPosReach = Math.min(i + nums[i], nums.length - 1);
            for (int j = i+1; j <=maxPosReach; j++) {
                if (dp[j]==1) {
                    dp[i] = 1;
                    break;
                }
            }

        }
        return dp[0]==1;
    }

    //Greedy is the best..
    public boolean canJumpGreedyMethod(int[] nums) {

        int endPos = nums.length -1;
        int i;
        for(i = nums.length-1; i >=0; i-- ){

            if(i + nums[i] >= endPos){
                endPos = i;
            }
        }
        return endPos == 0;
    }

    public boolean canJumpBestSolution(int[] nums) {
        int far = 0;
        if(nums.length==1) return true;

        for (int i=0; i<nums.length; i++) {
            if (i>far) return false;
            far = Math.max(far, i+nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new JumpGame().canJump(new int[]{3,2,1,0,4}));
        System.out.println(new JumpGame().canJumpWithDP(new int[]{2,3,1,1,4}));
        System.out.println(new JumpGame().canJumpWithDP(new int[]{3,2,1,0,4}));
        System.out.println(new JumpGame().canJumpGreedyMethod(new int[]{2,3,1,1,4}));
        System.out.println(new JumpGame().canJumpGreedyMethod(new int[]{3,2,1,0,4}));
        System.out.println(new JumpGame().canJumpWithBottomUp(new int[]{2,3,1,1,4}));
        System.out.println(new JumpGame().canJumpWithBottomUp(new int[]{3,2,1,0,4}));
        System.out.println(new JumpGame().canJumpBestSolution(new int[]{2,3,1,1,4}));
        System.out.println(new JumpGame().canJumpBestSolution(new int[]{3,2,1,0,4}));
    }

}
