package com.programming.leetcode.Medium;

import java.util.Stack;

public class ValidParanthesesScore {

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(char c: S.toCharArray()){
            if(c=='('){
                stack.push(0);
            }else{
                int o1 = Math.max(2 * stack.pop(),1);
                int o2 = stack.pop();
                int ans = o1 + o2;
                stack.push(ans);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ValidParanthesesScore obj = new ValidParanthesesScore();
        System.out.println(obj.scoreOfParentheses("()()"));
        System.out.println(obj.scoreOfParentheses("(()(()))"));
        System.out.println(obj.scoreOfParentheses("(())"));
    }
}
