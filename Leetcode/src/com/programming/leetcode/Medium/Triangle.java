package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    Integer minSum = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        helper(0,0,0,triangle);
        return minSum;
    }

    //Time Limit Exceeds..
    //Must be solved by Dynamic Programming
    void helper(int crt_level, int crt_pos, int crt_sum, List<List<Integer>> input){
        if(input.size() == crt_level){
            minSum= Math.min(crt_sum, minSum);
            return;
        }
        for(int i = crt_pos; i <crt_level+1; i++){
            if(i>crt_pos+1) return;
            crt_sum += input.get(crt_level).get(i);
            helper(crt_level+1,i,crt_sum,input);
            crt_sum -= input.get(crt_level).get(i);
        }
    }

    public int minimumTotalDP(List<List<Integer>> triangle) {
        int[] results = new int[triangle.size()+1];
        for(int i=triangle.size()-1; i>=0; i--) {
            for(int j=0; j<triangle.get(i).size(); j++) {
                results[j] = Math.min(results[j], results[j+1]) + triangle.get(i).get(j);
            }
        }
        return results[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(new Integer[]{2})));
        triangle.add(new ArrayList<>(Arrays.asList(new Integer[]{3,4})));
        triangle.add(new ArrayList<>(Arrays.asList(new Integer[]{6,5,7})));
        triangle.add(new ArrayList<>(Arrays.asList(new Integer[]{4,1,8,3})));
        System.out.println(new Triangle().minimumTotalDP(triangle));
        System.out.println(new Triangle().minimumTotal(triangle));
    }



}
