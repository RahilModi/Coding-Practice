package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfSquarefulArrays {

    class Result{
        int count = 0;
    }

    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        Result obj = new Result();
        backtrack(new ArrayList<>(), A, new boolean[A.length], -1, obj);
        return obj.count;
    }

    private void backtrack(List<Integer> crt, int[] nums, boolean[] visited, int lastNum, Result obj){
        if(crt.size() == nums.length)obj.count++;
        else{
            for(int i = 0; i < nums.length; i++){
                if(visited[i] || i>0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
                else if( lastNum != -1 && !isSquare(nums[i],lastNum)) continue;
                else{
                    crt.add(nums[i]);
                    visited[i] = true;
                    backtrack(crt, nums, visited,nums[i], obj);
                    visited[i] = false;
                    crt.remove(crt.size()-1);
                }
            }
        }
    }

    private boolean isSquare(int a, int b){
        return Math.sqrt(a+b) - Math.floor(Math.sqrt(a+b)) == 0;
    }

    public static void main(String[] args) {
        NumberOfSquarefulArrays obj = new NumberOfSquarefulArrays();
        System.out.println(obj.numSquarefulPerms(new int[]{1,17,8}));
    }
}
