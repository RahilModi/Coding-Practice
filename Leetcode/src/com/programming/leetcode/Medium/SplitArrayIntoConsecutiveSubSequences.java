package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubSequences {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>(), crtSequenceMap = new HashMap<>();
        for(int i : nums) counter.put(i, counter.getOrDefault(i,0)+1);
        for(int n : nums){
            if(counter.get(n) == 0) continue;
            else if(crtSequenceMap.getOrDefault(n,0) > 0){
                crtSequenceMap.put(n, crtSequenceMap.get(n)-1);
                crtSequenceMap.put(n+1, crtSequenceMap.getOrDefault(n+1,0)+1);
            }else if(counter.getOrDefault(n+1,0) > 0 && counter.getOrDefault(n+2, 0)>0){
                counter.put(n+1, counter.get(n+1)-1);
                counter.put(n+2, counter.get(n+2)-1);
                crtSequenceMap.put(n+3, crtSequenceMap.getOrDefault(n+3, 0)+1);
            }else return false;
            counter.put(n, counter.get(n)-1);
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayIntoConsecutiveSubSequences obj = new SplitArrayIntoConsecutiveSubSequences();
        System.out.println(obj.isPossible(new int[]{1,2,3,3,4,4,5,6}));
    }

}
