package com.programming.leetcode.Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicCalculatorIII {
    static Map<Character, Integer> precedence = new HashMap<>();
    {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('(',0);
    }
    public int calculate(String s) {
        if(s==null||s.isEmpty()) return 0;
        if(s.length()==1 && Character.isDigit(s.charAt(0)))return Integer.parseInt(s);
        Stack<Long> stack = new Stack<Long>();
        Stack<Character> operators = new Stack<>();
        long num = 0;
        boolean isClosingParantheses = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10+s.charAt(i)-'0';
                isClosingParantheses = false;
            }
            else if(Character.isWhitespace(c)) continue;
            else if(c=='('){
                operators.push(c);
            }else if(c == ')'){
                if(!isClosingParantheses) {
                    stack.push(num);
                    num = 0;
                }
                while (!operators.isEmpty() && operators.peek()!='(') {
                    stack.push(operation(operators.pop(), stack.pop(),stack.pop()));
                }
                operators.pop();
                isClosingParantheses = true;
            }else {
                if(!isClosingParantheses) {
                    stack.push(num);
                    num = 0;
                }
                isClosingParantheses = false;
                if(operators.isEmpty()) operators.push(c);
                else {
                    int prec = precedence.get(c);
                    while (!operators.isEmpty() && prec <= precedence.get(operators.peek())) {
                        stack.push(operation(operators.pop(), stack.pop(),stack.pop()));
                    }
                    operators.push(c);
                }
            }
        }
        if(num>0)
            stack.push(num);
        while (stack.size() >1){
            stack.push(operation(operators.pop(), stack.pop(),stack.pop()));
        }
        return stack.pop().intValue();
    }

    private long operation(char c, long num1, long num2){
        if(c == '+'){
            return num2+num1;
        }else if(c == '-'){
            return num2-num1;
        }else if(c == '*'){
            return num2*num1;
        }else{
            return num2/num1;
        }
    }

    public static void main(String[] args) {
        BasicCalculatorIII obj = new BasicCalculatorIII();
        System.out.println(obj.calculate("0-2147483648"));
    }
}
