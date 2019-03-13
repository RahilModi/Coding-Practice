package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        int id = 0;
        for(int i : nums1){
            res[id++] = map.getOrDefault(i, -1);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementI obj = new NextGreaterElementI();
        System.out.println();
    }
}
