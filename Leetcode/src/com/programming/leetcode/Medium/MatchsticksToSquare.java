package com.programming.leetcode.Medium;

import java.util.Arrays;

public class MatchsticksToSquare {

    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length < 4)return false;
        long sum = 0;
        for (int num : nums) sum += num;
        if(sum % 4 != 0) return false;
        return dfs(nums, 0,4, sum/4, new boolean[nums.length], 0);
    }

    private boolean dfs(int[] A, int stIndx, int k, long target, boolean[] seen, int crtSum){
        if(k == 1) return true;
        if(crtSum == target)
            return dfs(A, 0,k-1, target, seen, 0);
        for(int i = stIndx; i < A.length; i++){
            if(!seen[i] && A[i]+crtSum <= target){
                crtSum += A[i];
                seen[i] = true;
                if(dfs(A, i+1, k, target, seen, crtSum)) return true;
                crtSum -= A[i];
                seen[i] = false;
            }
        }
        return false;
    }

    public boolean makesquareV1(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;

        return dfsV1(nums, new int[4], 0, sum / 4);
    }

    private boolean dfsV1(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] > target) continue;
            sums[i] += nums[index];
            if (dfsV1(nums, sums, index + 1, target)) return true;
            sums[i] -= nums[index];
        }

        return false;
    }

    public static void main(String[] args) {
        MatchsticksToSquare obj = new MatchsticksToSquare();
//        System.out.println(obj.makesquare(new int[]{1,1,2,2,2}));
//        System.out.println(obj.makesquare(new int[]{4,3,3,3,3}));
        System.out.println(obj.makesquare(new int[]{5,5,5,5,16,4,4,4,4,4,3,3,3,3,4}));
    }

}
