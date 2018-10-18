package com.programming.leetcode.Medium;

public class SubArrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int begin = 0, end = 0, product = 1, count = 0;
        while(end < nums.length){
            product *= nums[end];
            while(begin <= end && product >= k ){
                product /= nums[begin++];
            }
            count += (end - begin + 1);
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        SubArrayProductLessThanK obj = new SubArrayProductLessThanK();

        System.out.println(obj.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));

    }

}
