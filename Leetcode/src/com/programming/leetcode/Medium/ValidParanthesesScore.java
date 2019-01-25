package com.programming.leetcode.Medium;

import java.util.Stack;

public class ValidParanthesesScore {

    public int scoreOfParentheses(String S) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(c == ')'){
                operands.push(1);
                if( i + 1 < S.length() ) {
                    if (S.charAt(i + 1) == '(') {
                        operators.push('+');
                    } else {
                        operators.push('*');
                        operands.push(2);
                    }
                }else if(i == S.length()-1){
                    operators.push('*');
                    operands.push(1);
                }
            }
        }
        while(!operands.isEmpty() && !operators.isEmpty()){
            int op1 = operands.pop();
            int op2 = operands.pop();
            switch (operators.pop()) {
                case '+': {
                    operands.push(op1 + op2);
                    break;
                }
                case '*': {
                    operands.push(op1 * op2);
                    break;
                }
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {
        ValidParanthesesScore obj = new ValidParanthesesScore();
        System.out.println(obj.scoreOfParentheses("()"));
        System.out.println(obj.scoreOfParentheses("(()(()))"));
        System.out.println(obj.scoreOfParentheses("(())"));
    }
}
