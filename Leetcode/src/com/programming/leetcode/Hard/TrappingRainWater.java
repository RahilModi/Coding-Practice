package com.programming.leetcode.Hard;

import java.util.Stack;

public class TrappingRainWater {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int max_tap = 0;
        for(int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                max_tap += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[top]);
            }
            stack.push(i);
        }
        return max_tap;
    }

    //Two Pointers....
    public int trapII(int[] height) {
        int leftPos = 0, rightPos = height.length-1;
        int leftMax = 0, rightMax =0;
        int ans = 0;
        while(leftPos<rightPos){
            if(height[leftPos] < height[rightPos]){
                if(height[leftPos] >= leftMax){
                    leftMax = height[leftPos];
                }else {
                    ans += leftMax - height[leftPos];
                }
                leftPos++;
            }else{
                if(height[rightPos] >= rightMax){
                    rightMax = height[rightPos];
                }else {
                    ans += rightMax - height[rightPos];
                }
                rightPos--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        System.out.println(obj.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}
