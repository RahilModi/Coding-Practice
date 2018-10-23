package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        helper(nums, 0, S , 0);
        return count;
    }

    private boolean helper(int[] nums, int index, int sumTarget, int crtSum){
        if(index == nums.length && sumTarget == crtSum) return true;
        else if(index >= nums.length) return false;
        else {
            if (helper(nums, index + 1, sumTarget, crtSum + nums[index]))
                count++;
            if (helper(nums, index + 1, sumTarget, crtSum - nums[index]))
                count++;
        }

        return false;
    }


    private int helperFunc(int[] nums, int index, int sumTarget, int crtSum, Map<String, Integer> map){
        String encoding = index + "->" + crtSum;
        if(map.containsKey(encoding)) return map.get(encoding);
        if(index == nums.length && sumTarget == crtSum) return 1;
        else if(index >= nums.length) return 0;
        else {
            int add = helperFunc(nums, index + 1, sumTarget, crtSum + nums[index], map);
            int minus = helperFunc(nums, index + 1, sumTarget, crtSum - nums[index], map);
            map.put(encoding, add + minus);
            return add + minus;
        }
    }

    public int findTargetSumWaysV2(int[] nums, int S) {
      return helperFunc(nums, 0, S , 0, new HashMap<>());
    }

    public int findTargetSumWaysDP(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--) {
                //System.out.println(i + "->" + (i - n));
                dp[i] += dp[i - n];
            }
        return dp[s];
    }

    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWaysV2(new int[]{1,1,1,1,1}, 3));
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1,1,1,1,1}, 3));
        System.out.println(new TargetSum().findTargetSumWaysDP(new int[]{1,1,1,1,1}, 3));
    }
}
