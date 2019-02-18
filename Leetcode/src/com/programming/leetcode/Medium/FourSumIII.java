package com.programming.leetcode.Medium;

import java.util.*;

public class FourSumIII {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<int[]>> sumOfPairs = new HashMap<>();
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                List<int[]> prev = sumOfPairs.getOrDefault(nums[i]+nums[j], new ArrayList<>());
                prev.add(new int[]{i,j});
                sumOfPairs.put(nums[i]+nums[j],prev);
                //sumOfPairs.computeIfAbsent(nums[i]+nums[j], k -> new ArrayList<>()).add(new int[]{i,j});
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                int crtSum = nums[i]+nums[j];
                int diff = target-crtSum;
                if(sumOfPairs.containsKey(diff)){
                    List<int[]> previousPairs= sumOfPairs.get(diff);
                    for(int[] pair : previousPairs){
                        if(pair[0] == i || pair[1] == j || pair[0] == j || pair[1]==i){
                            continue;
                        }else {
                            List<Integer> result = Arrays.asList(new Integer[]{nums[pair[0]],nums[pair[1]],nums[i],nums[j]});
                            Collections.sort(result);
                            if(!res.contains(result))
                                res.add(result);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSumIII obj = new FourSumIII();
        obj.fourSum(new int[]{1, 0, -1, 0, -2, 2},0);
    }
}
