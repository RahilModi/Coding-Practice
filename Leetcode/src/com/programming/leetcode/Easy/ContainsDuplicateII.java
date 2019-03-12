package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(numIndexMap.containsKey(nums[i])){
                if(Math.abs(numIndexMap.get(nums[i])-i) <= k) return true;
            }else{
                numIndexMap.put(nums[i],i);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateV1(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII obj = new ContainsDuplicateII();
        System.out.println(obj.containsNearbyDuplicate(new int[]{1,2,3,1},3));
    }

}
