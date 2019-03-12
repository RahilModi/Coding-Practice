package com.programming.leetcode.Easy;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i : nums){
            if(i!=val)nums[j++] = i;
        }
        return j;
    }
}
