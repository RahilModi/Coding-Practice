package com.programming.leetcode.Hard;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubSequences {

    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] len = new int[n], cnt = new int[n];
        int maxLen = 0, maxNums = 0;
        Arrays.fill(len,1);
        Arrays.fill(cnt,1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j<i; j++){
                if(nums[i]>nums[j]){
                    if(len[i] == len[j]+1) cnt[i] += cnt[j];
                    if(len[i] < len[j]+1){
                        len[i] = len[j]+1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(maxLen == len[i]) maxNums += cnt[i];
            if(maxLen < len[i]){
                maxLen = len[i];
                maxNums = cnt[i];
            }
        }
        return maxNums;
    }


    public static void main(String[] args) {
        NumberOfLongestIncreasingSubSequences obj = new NumberOfLongestIncreasingSubSequences();
        System.out.println(obj.findNumberOfLIS(new int[] {1,3,5,4,7}));
    }
}
