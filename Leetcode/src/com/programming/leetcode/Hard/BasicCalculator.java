package com.programming.leetcode.Hard;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        boolean isConsecutiveOperations = false;
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isWhitespace(c)) continue;
            else if(c == '('){
                isConsecutiveOperations = false;
                operators.push('(');
            }
            else if(c == ')'){
                while(!operators.isEmpty() && operators.peek() != '('){
                    operands.push(operation(operators.pop(),operands.pop(),!operands.isEmpty() ? operands.pop(): 0));
                }
                operators.pop();
                isConsecutiveOperations = true;
            }
            else if(Character.isDigit(c)){
                int num  =0;
                while (i<s.length() && Character.isDigit(s.charAt(i))){
                    num = 10 * num + (int)s.charAt(i)-'0';
                    i++;
                }
                i--;
                operands.push(num);
            }else{
                if(isConsecutiveOperations && operands.size() >= 2) {
                    operands.push(operation(operators.pop(),operands.pop(),!operands.isEmpty() ? operands.pop(): 0));
                }
                operators.push(c);
                isConsecutiveOperations = true;
            }
        }

        return operands.size() > 1 ? operands.push(operation(operators.pop(),operands.pop(),operands.pop())) : operands.pop();
    }

    private int operation(char c, int num2, int num1){
        if(c == '+'){
            return num1+num2;
        }else{
            return num1-num2;
        }
    }


    public int calculateV1(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator obj = new BasicCalculator();
        System.out.println(obj.calculate(" 1-11 "));
        System.out.println(obj.calculate(" (7)-(0)+(4) "));
    }


}
