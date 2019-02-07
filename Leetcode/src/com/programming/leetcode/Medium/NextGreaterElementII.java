package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int [] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] >= nums[i]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                    res[stack.pop()] = nums[i];
                }
                stack.push(i);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length && !stack.isEmpty();i++){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                res[stack.pop()] = nums[i];
            }
            if(!stack.isEmpty() && i == stack.peek()) {
                break;
            }
        }
        while(!stack.isEmpty()){
            res[stack.pop()] = -1;
        }



//        for(int i = 0; i < nums.length && !stack.isEmpty(); i++){
//            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
//                res[stack.pop()] = nums[i];
//            }
//            while (!stack.isEmpty() && nums[stack.peek()] == nums[i]){
//                res[stack.pop()] = -1;
//            }
//        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementII obj = new NextGreaterElementII();
        System.out.println(Arrays.toString(obj.nextGreaterElements(new int[]{1,1,1,1,1})));

        System.out.println(Arrays.toString(obj.nextGreaterElements(new int[]{5,4,3,2,1})));

        System.out.println(Arrays.toString(obj.nextGreaterElements(new int[]{1,2,1})));
    }
}
