package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {

    //O(nlogn)
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums == null || upper < lower) return res;
        long ptr = lower;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < lower || i<nums.length-1 && nums[i]==nums[i+1]) continue;
            if(nums[i] > upper || ptr > upper) break;
            if(nums[i] != ptr){
                if ( ptr == nums[i]-1) {
                    res.add("" + ptr);
                } else {
                    res.add(ptr + "->" + (nums[i]-1));
                }
                ptr = nums[i];
            }
            ptr++;
        }
        if( ptr < upper ){
            res.add(ptr + "->"+ upper);
        }else if(ptr == upper){
            res.add(ptr+"");
        }
        return res;
    }


    public static void main(String[] args) {
        MissingRanges obj = new MissingRanges();
        System.out.println(obj.findMissingRanges(new int[]{}, 0,Integer.MAX_VALUE));

        System.out.println(obj.findMissingRanges(new int[]{Integer.MAX_VALUE}, 0,Integer.MAX_VALUE));

        System.out.println(obj.findMissingRanges(new int[]{0, 1,2,3, 23,50, 75}, 0,75));
    }



    public List<String> findMissingRangesV1(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<String>();

        // the next number we need to find
        int next = lo;

        for (int i = 0; i < a.length; i++) {
            // not within the range yet
            if (a[i] < next) continue;

            // continue to find the next one
            if (a[i] == next) {
                next++;
                continue;
            }
            res.add(getRange(next, a[i] - 1));

            next = a[i] + 1;
        }

        if (next <= hi) res.add(getRange(next, hi));

        return res;
    }

    String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }

}
