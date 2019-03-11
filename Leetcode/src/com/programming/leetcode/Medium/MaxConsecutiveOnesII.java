package com.programming.leetcode.Medium;

import com.programming.leetcode.Easy.MaxConsecutiveOnes;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int ptr1 = 0, ptr2 = 1, max = 0, lastIndexOfZero = 0;
        boolean bZeroFound = false, bMultipleFound = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 1) {
                if (!bZeroFound) {
                    lastIndexOfZero = i;
                    bZeroFound = true;
                } else {
                    max = Math.max(max, ptr2 - ptr1 - 1);
                    ptr1 = lastIndexOfZero + 1;
                    lastIndexOfZero = i;
                    bMultipleFound = true;
                }
            }
            ptr2++;
        }
        return lastIndexOfZero == nums.length-1 && bMultipleFound ? max : Math.max(max, ptr2-ptr1-1);
    }

    public int findMaxConsecutiveOnesV1(int[] nums) {
        int max = 0, q = -1;
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) {
                l = q + 1;
                q = h;
            }
            max = Math.max(max, h - l + 1);
        }
        return max;
    }

    //For FOLLOW UP...O(n) time and O(k) space...
    public int findMaxConsecutiveOnesV2(int[] nums) {
        int max = 0, k = 1; // flip at most k zero
        Queue<Integer> zeroIndex = new LinkedList<>();
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0)
                zeroIndex.offer(h);
            if (zeroIndex.size() > k)
                l = zeroIndex.poll() + 1;
            max = Math.max(max, h - l + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesII obj = new MaxConsecutiveOnesII();
        System.out.println(obj.findMaxConsecutiveOnes(new int[]{1,0}));
    }
}
