package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    //TLE
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            int  numZeros = 0, numOnes = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == 0) numZeros++;
                else numOnes++;
                if(numOnes == numZeros) maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }

    //Using Map
    public int findMaxLengthV1(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        countMap.put(0,-1);
        int count =0, maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            count+= nums[i]==0? -1 : 1;
            if(countMap.containsKey(count)){
                maxLen = Math.max(maxLen, i-countMap.get(count));
            }else {
                countMap.put(count,i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        ContiguousArray obj = new ContiguousArray();
        System.out.println(obj.findMaxLengthV1(new int[]{0,1,0,1,0}));
        System.out.println(obj.findMaxLength(new int[]{0,1,0,1,0,1}));
    }
}
