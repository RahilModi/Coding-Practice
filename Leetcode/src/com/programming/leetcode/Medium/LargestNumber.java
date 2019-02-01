package com.programming.leetcode.Medium;

import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] res = new String[nums.length];
        int idx= 0;
        for(int i: nums){
            res[idx++] = String.valueOf(i);
        }
        Arrays.sort(res, (a,b)->{ String s1 = a+b; String s2 = b+a ; return s1.compareTo(s2);});
        if(res[res.length-1].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(int i = res.length-1; i >= 0; i--){
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber obj = new LargestNumber();
        System.out.println(obj.largestNumber(new int[]{10,2}));
    }
}
