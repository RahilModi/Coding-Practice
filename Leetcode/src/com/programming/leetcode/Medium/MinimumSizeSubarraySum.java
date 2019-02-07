package com.programming.leetcode.Medium;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int crt_sum = 0, min_dist = Integer.MAX_VALUE;
        int i=0,j=i;
        while(i < nums.length){
            crt_sum += nums[i];
            while (crt_sum >= s){
                min_dist = Math.min(min_dist, i-j+1);
                crt_sum -= nums[j++];
            }
            i++;
        }
        return min_dist == Integer.MAX_VALUE ? 0 : min_dist;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum obj =new MinimumSizeSubarraySum();
        System.out.println(obj.minSubArrayLen(11,new int[]{1,2,3,4,5}));
        System.out.println(obj.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
