package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicCalculatorII {

    static Map<Character, Integer> precedence = new HashMap<>();
    {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
    }
    public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int num = 0;
        for(int  i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = 10 * num + (int) c-'0';
            }
            else if(Character.isWhitespace(c)) continue;
            else{
                numbers.push(num);
                num=0;
                if(operators.isEmpty()) operators.push(c);
                else {
                    int prec = precedence.get(c);
                    while (!operators.isEmpty() && prec <= precedence.get(operators.peek())) {
                        numbers.push(operation(operators.pop(), numbers.pop(),numbers.pop()));
                    }
                    operators.push(c);
                }
            }
        }
        numbers.push(num);
        while (numbers.size() >1){
            numbers.push(operation(operators.pop(), numbers.pop(),numbers.pop()));
        }
        return numbers.pop();
    }

    private int operation(char c, int num1, int num2){
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

    public int calculateV2(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char prev = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(prev=='-'){
                    stack.push(-num);
                }
                if(prev=='+'){
                    stack.push(num);
                }
                if(prev=='*'){
                    stack.push(stack.pop()*num);
                }
                if(prev=='/'){
                    stack.push(stack.pop()/num);
                }
                prev = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }

    public static void main(String[] args) {
        BasicCalculatorII obj = new BasicCalculatorII();
        System.out.println(obj.calculateV2("1*2-3/4+5*6-7*8+9/10"));
        System.out.println(obj.calculate("3/2"));
        System.out.println(obj.calculate("3+2*2"));
    }
}
