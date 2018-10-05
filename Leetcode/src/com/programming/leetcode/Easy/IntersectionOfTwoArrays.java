package com.programming.leetcode.Easy;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {

        if((nums1.length == 0 && nums2.length == 0) || nums1.length == 0 || nums2.length == 0)  return new int[]{};

        Set<Integer> res = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        for(int num : nums1)
            temp.add(num);

        for(int num : nums2){
            if(temp.contains(num)){
                res.add(num);
            }
        }

        int[] result = new int[res.size()];
        int index = 0;
        for(Object o : res){
            result[index++] = ((Integer) o).intValue();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] res = IntersectionOfTwoArrays.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        for(int num : res) System.out.println(num);

    }
}
