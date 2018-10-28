package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class BeautifulArrangements {

    int count = 0;
    public int countArrangement(int N) {
        int[] nums  = IntStream.range(1,N+1).toArray();
        backtrackingPermutation( nums, 0, new boolean[nums.length]);
        return count;
    }

    private void backtrackingPermutation(int[] nums, int index, boolean[] visited){
        if(index == nums.length){
            count++;
            return;
        }
        for(int pos = 0; pos < nums.length; pos++){
            if(!visited[pos] && ((index+1) % (pos+1) == 0 || ((pos+1) % (index+1) == 0 ))){
                visited[pos] = true;
                backtrackingPermutation(nums, index+1, visited);
                visited[pos] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new BeautifulArrangements().countArrangement(3));
    }
}
