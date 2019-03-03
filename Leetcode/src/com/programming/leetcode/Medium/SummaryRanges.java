package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums ==null || nums.length == 0) return res;
        if(nums.length<2) {
            res.add(nums[0]+"");
            return res;
        }
        int ptr1=0;
        for(int i = 1; i < nums.length; i++){
            ptr1 = i-1;
            while (i <nums.length && nums[i-1]+1 == nums[i]){
                i++;
            }
            if(i-ptr1==1){
                res.add(nums[ptr1]+"");
            }else{
                res.add(nums[ptr1]+"->"+nums[i-1]);
            }
            ptr1 = i;
        }
        if(ptr1 == nums.length-1){
            res.add(nums[ptr1]+"");
        }
        return res;
    }

    public static void main(String[] args) {
        SummaryRanges obj = new SummaryRanges();
        System.out.println(obj.summaryRanges(new int[]{0,2,5,8,10}));
    }

}
