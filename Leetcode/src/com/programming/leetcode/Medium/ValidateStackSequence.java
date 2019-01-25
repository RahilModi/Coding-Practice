package com.programming.leetcode.Medium;

import java.util.Stack;

public class ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack =new Stack<>();
        int poppedIndex = 0;
        for(int num : pushed){
            stack.push(num);
            while (!stack.isEmpty() && poppedIndex < popped.length && stack.peek() == popped[poppedIndex]){
                stack.pop();
                poppedIndex++;
            }
        }

        while(!stack.isEmpty()){
            if(popped[poppedIndex] != stack.peek()) return false;
            else {
                poppedIndex++;
                stack.pop();
            }
        }

        return poppedIndex == popped.length && stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidateStackSequence sequence = new ValidateStackSequence();
        System.out.println(sequence.validateStackSequences(new int[]{2,1,0}, new int[]{1,2,0}));
        System.out.println(sequence.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(sequence.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
}
