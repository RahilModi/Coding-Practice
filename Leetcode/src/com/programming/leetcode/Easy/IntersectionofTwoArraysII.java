package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[]{};

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i =0, j = 0;
        List<Integer> result = new ArrayList<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        return result.stream().mapToInt(k->k).toArray();
    }

}
