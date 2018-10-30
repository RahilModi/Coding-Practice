package com.programming.leetcode.Medium;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i = T.length-1; i >= 0 ; i--){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return res;
    }
}
