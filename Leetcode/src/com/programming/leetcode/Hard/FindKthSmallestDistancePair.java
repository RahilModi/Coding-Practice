package com.programming.leetcode.Hard;

import java.util.Arrays;

public class FindKthSmallestDistancePair {

    private int countPairs(int[] nums, int t){
        int n = nums.length;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int j = i+1;
            while(j < n && nums[j]-nums[i] <= t) j++;
            res += j-i-1;
        }
        return res;
    }
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = nums[1] - nums[0];
        for(int i = 1; i < n -1; i++){
            low = Math.min(low, nums[i+1]-nums[i]);
        }

        int high = nums[n-1] - nums[0];
        while (low < high){
            int mid = (low + high) >> 1;
            if(countPairs(nums, mid) < k){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        FindKthSmallestDistancePair obj = new FindKthSmallestDistancePair();
        System.out.println(obj.smallestDistancePair(new int[]{1,3,1},1));
    }

}
