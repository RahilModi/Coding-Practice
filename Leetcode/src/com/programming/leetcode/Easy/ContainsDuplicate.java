package com.programming.leetcode.Easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) return false;
        final Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(!set.add(i)) return true;
        }
        return false;

    }
}
