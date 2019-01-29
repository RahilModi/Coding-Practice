package com.programming.leetcode.Medium;

import java.util.Stack;

public class EvaluateRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        for(int i = 0 ; i < tokens.length ;i++){
            if(isOperator(tokens[i])){
                int num_2 = operands.pop();
                int num_1 = operands.pop();
                operands.push(evaluation(num_1,num_2,tokens[i]));
            }
            else{
                operands.push(Integer.parseInt(tokens[i]));
            }
        }
        return operands.isEmpty() ? 0 : operands.pop();
    }

    private int evaluation(int num1, int num2, String operator){
        switch (operator){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "/":
                return num1/num2;
            case "*":
                return num1 * num2;
            default:
                return Integer.MAX_VALUE;
        }
    }

    private boolean isOperator(String token){
        switch (token){
            case "+":
            case "-":
            case "/":
            case "*":
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        EvaluateRPN obj = new EvaluateRPN();
        System.out.println(obj.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
