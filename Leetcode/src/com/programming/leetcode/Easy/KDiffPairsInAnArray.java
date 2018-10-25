package com.programming.leetcode.Easy;

import java.util.*;

public class KDiffPairsInAnArray {

    Map<Integer, Integer> temp = new HashMap<>();
    Set<String> alreadyConsidered = new HashSet<>();
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) return 0;
        int count = 0;
        for(int i = 0; i < nums.length ; i++){
            if(!isAlreadyConsidered(nums[i], k, '-')) {
                if (temp.containsKey(nums[i] - k)) {
                    alreadyConsidered.add(nums[i] + "-->" + (nums[i]-k));
                    count++;
                }
            }
            if(!isAlreadyConsidered(nums[i], k, '+')) {
                 if (temp.containsKey(nums[i] + k)) {
                     alreadyConsidered.add(nums[i] + "-->" + (nums[i]+k));
                     count++;
                }
            }
            temp.put(nums[i], i);

        }
        return count;

    }

    private boolean isAlreadyConsidered(int num1, int num2, char operator){
        if(operator == '-') {
            return alreadyConsidered.contains( (num1-num2) + "-->" + num1) || alreadyConsidered.contains(num1 + "-->"+ (num1-num2));
        }else{
            return alreadyConsidered.contains( (num1+num2) + "-->" + num1) || alreadyConsidered.contains(num1 + "-->"+ (num1+num2));
        }
    }

    public int findPairsV2(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) return 0;
        Map<Integer, Integer> temp = new HashMap<>();
        for(int i = 0; i < nums.length ;i++) temp.put(nums[i],temp.getOrDefault(nums[i],0)+1);
        int count = 0;
        for(Integer key : temp.keySet()){
            if(k == 0 && temp.get(key) >= 2 ) {
                count++;
            }else{
                if(temp.containsKey(key + k)){
                    count++;
                }
            }
        }
        return count;
    }

    public int findPairsV3(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1 ; j< nums.length ; j++){
                if(j > (i+1) && nums[j] == nums[j-1]) continue;
                int diff = nums[j] - nums[i];
                if(diff == k){
                    count++;
                }if(diff > k) break;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new KDiffPairsInAnArray().findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(new KDiffPairsInAnArray().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(new KDiffPairsInAnArray().findPairsV2(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(new KDiffPairsInAnArray().findPairs(new int[]{1,2,3,4,5},-1));
        System.out.println(new KDiffPairsInAnArray().findPairsV3(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(new KDiffPairsInAnArray().findPairsV3(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(new KDiffPairsInAnArray().findPairsV3(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(new KDiffPairsInAnArray().findPairsV3(new int[]{1,1,1,1,1}, 0));
    }


}
