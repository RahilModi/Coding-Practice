package com.programming.leetcode.Medium;

import java.util.*;
import java.util.stream.IntStream;

public class PartitionEqualSubSetSum {

    public boolean canPartition(int[] nums) {
        int total = 0;
        Map<Integer, Integer> map =new HashMap<>();
        for(int i : nums){
            total += i;
            map.put(i, map.getOrDefault(i,0)+1);
        }
        if((total & 1) == 1) return false;
        return helper(map, total>>1);
    }
    public boolean helper(Map<Integer,Integer> map, int target){
        if(map.containsKey(target) && map.get(target) > 0) return true;
        for(int key : map.keySet()){
            if(key < target && map.get(key)>0){
                map.put(key, map.get(key)-1);
                if(helper(map, target-key)) return true;
                map.put(key, map.get(key)+1);
            }
        }
        return false;
    }

    //Knapsack problem...
    //uses O(n*total) space
    public boolean partitionEqualSum(int[] input){
        int total = IntStream.of(input).sum();
        if((total & 1) == 1) return false;
        total >>=1;
        boolean dp[][] = new boolean[input.length+1][total+1];
        for(int i = 0; i < dp.length; i++) dp[i][0] = false;
        for(int j = 0; j < dp[0].length; j++) dp[0][j] = true;
        dp[0][0] = true;
        for(int i = 1; i < dp.length; i++){
            int num = input[i-1];
            for(int j = 1; j < dp[0].length; j++){
                if(j >= num){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-num];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[input.length][total];
    }

    //Improving space to O(sum)
    public boolean canPartitionUsingDP(int[] nums) {
        int total = IntStream.of(nums).sum();
        if((total & 1) == 1) return false;
        total >>=1;
        boolean[] dp = new boolean[total+1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = total; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[total];
    }

    public static void main(String[] args) {
        PartitionEqualSubSetSum obj = new PartitionEqualSubSetSum();
        System.out.println(obj.partitionEqualSum(new int[]{1,5,10,5,2,3,12,32}));
        System.out.println(obj.canPartition(new int[]{1,5,10,5,2,3,12,32}));
    }
}
