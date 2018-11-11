package com.programming.leetcode.Hard;

public class medianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
           return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length, y = nums2.length;
        boolean isOdd = ((x+y)%2) == 0 ? false : true;
        int start = 0, end = x;
        double ans = 0.0;
        while(start<=end){
            int partitionX = (start+end)/2;
            int partitionY = (x+y+1)/2 - partitionX;
            int maxLeftX = partitionX==0? Integer.MIN_VALUE : nums1[partitionX-1];
            int maxLeftY = partitionY==0? Integer.MIN_VALUE : nums2[partitionY-1];

            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY<= minRightX){
                ans = isOdd ? (double) Math.max(maxLeftX,maxLeftY) : ((double)Math.max(maxLeftX,maxLeftY) + Math.min(minRightX, minRightY))/2;
                break;
            }else if(maxLeftX > minRightY){
                end = partitionX -1;
            }else{
                start = partitionX +1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,8,9,15};
        int[] nums2 = {7,11,19,21,28,40};
        System.out.println(new medianOfTwoSortedArray().findMedianSortedArrays(nums1,nums2));
    }
}
