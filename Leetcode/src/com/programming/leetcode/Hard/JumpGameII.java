package com.programming.leetcode.Hard;

public class JumpGameII {

    //minimum jumps to reach the end from the starting index..
    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = 0;
        for(int i = 1; i < nums.length; i++){
            dp[i] = Integer.MAX_VALUE-1;
            for(int j = 0; j<i; j++){
                if(i-j <= nums[j]){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[nums.length-1];

    }

    public int jumpV1(int [] nums){
        int sc, e,max;
        sc = e = max = 0;
        for(int i = 0; i < nums.length -1; i++){
            max = Math.max(max, i + nums[i]);
            if(i == e){
                sc++;
                e = max;
            }
        }
        return sc;
    }

    public static void main(String[] args) {
        JumpGameII obj = new JumpGameII();
        System.out.println(obj.jumpV1(new int[]{2,3,1,1,4}));
    }
}
