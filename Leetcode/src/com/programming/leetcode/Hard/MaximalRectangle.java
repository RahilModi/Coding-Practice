package com.programming.leetcode.Hard;

import java.math.BigInteger;
import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[] height = new int[numCols+1];
        height[numCols] = 0;
        int maxArea = 0;
        for(int i = 0; i <numRows; i++){
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j <numCols+1; j++){
                if(j < numCols){
                    if(matrix[i][j] == '1'){
                        height[j] += 1;
                    }else height[j] = 0;
                }
                while (!stack.isEmpty() && height[stack.peek()] > height[j]){
                    int top = stack.pop();
                    int area = height[top] * (stack.isEmpty() ? j : (j - stack.peek() - 1));
                    maxArea = Math.max(area, maxArea);
                }
                stack.push(j);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }
}
