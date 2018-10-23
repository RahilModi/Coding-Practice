package com.programming.leetcode.Medium;

public class MaxWater {

    public int maxArea(int[] height) {
        int firstPtr = 0, secondPtr = height.length -1;
        int maxArea = Integer.MIN_VALUE;
        while (firstPtr < secondPtr){
            int maxHeight = Math.min(height[firstPtr], height[secondPtr]);
            int crt_area = maxHeight * (secondPtr -firstPtr);
            if(crt_area > maxArea){
                maxArea = crt_area;
            }
            if(height[firstPtr] < height[secondPtr]) firstPtr++;
            else secondPtr--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new MaxWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

}
