package com.programming.leetcode.Hard;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0 ; i <= heights.length ; i++){
            int crt_height = i == heights.length ? 0 : heights[i];
            if(stack.isEmpty() || crt_height >= heights[stack.peek()]){
                stack.push(i);
            }else{
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty()? i : i-1-stack.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public int largestRectangleAreaV2(int[] heights){
        Stack<Integer> st1 = new Stack<>();
        int max=0,area= 0;
        int curr=0;
        int i = 0;
        for( ;i<heights.length; ){
            if(st1.isEmpty() || heights[st1.peek()] <= heights[i]) {
                st1.push(i++);
            }else {
                curr=st1.pop();
                area = st1.empty() ? heights[curr]* i : heights[curr]*(i-st1.peek()-1);
                max = Math.max(area, max);
            }
        }
        while(st1.size()!=0){
            curr=st1.pop();
            area = st1.empty() ? heights[curr]* i : heights[curr]*(i-st1.peek()-1);
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main(String[] args) {
        new LargestRectangleInHistogram().largestRectangleArea(new int[]{2,1,5,6,2,3});
        new LargestRectangleInHistogram().largestRectangleAreaV2(new int[]{2,1,5,6,2,3});
    }
}
