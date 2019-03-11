package com.programming.leetcode.Medium;

import java.util.Stack;

public class CheckWordIsValidAfterSubStitution {

    public boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        for(Character c : S.toCharArray()){
            if(c == 'c'){
                if(stack.isEmpty() || stack.pop() != 'b') return false;
                if(stack.isEmpty() || stack.pop() != 'a') return false;
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
