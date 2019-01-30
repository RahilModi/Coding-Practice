package com.programming.leetcode.Medium;

/***
 * Given an array of positive integers where successive elements increase by 1 (except for a single element that does NOT increase by one--the start of the "corruption"), return the index of where the corruption starts.
 *
 * Example 1:
 *
 * array: [5, 6, 7, 8, 12, 13]
 * indices: 0 1 2 3 4 5
 *
 * The corruption starts at index 4.
 *
 * Example 2:
 *
 * array: [5, 2, 3, 4, 5, 6]
 * indices: 0 1 2 3 4 5
 *
 * The corruption starts at index 1.
 *
 * P.S. My solution was of O(n), also I tried to branch it in two parts still it will reduce half.
 *
 * Hint: I was told I can use binary search.
 */
public class CorruptedIndex {

    public int corruptedElementPos(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid-left == nums[mid]-nums[left]) left = mid+1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        CorruptedIndex obj = new CorruptedIndex();
        System.out.println(obj.corruptedElementPos(new int[]{5,2,3,4,5,6}));
        System.out.println(obj.corruptedElementPos(new int[]{5, 6, 7, 8, 9, 15}));

    }
}
