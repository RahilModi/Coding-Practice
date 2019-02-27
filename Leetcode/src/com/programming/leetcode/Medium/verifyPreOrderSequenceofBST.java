package com.programming.leetcode.Medium;

import java.util.Stack;

public class verifyPreOrderSequenceofBST {

    //O(n)
    public boolean verifyPreorder(int[] preorder) {
        Integer low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i : preorder){
            if(i < low) return false;
            while (!stack.isEmpty() && i > stack.peek()){
                low = stack.pop();
            }
            stack.push(i);
        }
        return true;
    }

    //O(1)
    public boolean verifyPreorderV1(int[] preorder) {
        Integer low = Integer.MIN_VALUE, index = 0;
        for(int p : preorder){
            if(p < low) return false;
            while (index > 0 && p > preorder[index-1]){
                low = preorder[--index];
            }
            preorder[index++] = p;
        }
        return true;
    }

    public static void main(String[] args) {
        verifyPreOrderSequenceofBST obj = new verifyPreOrderSequenceofBST();
        System.out.println(obj.verifyPreorderV1(new int[]{5,2,6,1,3}));
    }
}
