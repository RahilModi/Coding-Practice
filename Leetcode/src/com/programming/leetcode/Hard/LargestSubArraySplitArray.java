package com.programming.leetcode.Hard;

public class LargestSubArraySplitArray {

    public int splitArray(int[] nums, int m) {

        int max = 0;
        long sum = 0;
        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }

        if(m==1) return (int)sum;
        long l = max, r = sum;
        while (l<=r){
            long mid = l+(r-l)/2;
            if(valid(nums, mid, m)){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return (int)l;
    }

    private boolean valid(int [] nums, long target, int m){
        int count = 1;
        long total = 0;
        for(int n : nums){
            total+= n;
            if(total > target){
                count++;
                total = n;
                if(count > m)return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LargestSubArraySplitArray obj = new LargestSubArraySplitArray();
        System.out.println(obj.splitArray(new int[]{7,2,5,10,8},2));
    }
}
