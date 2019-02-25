package com.programming.leetcode.Medium;

import java.util.Stack;

public class TernaryExpressionParser {

    public String parseTernary(String expression) {
        if(expression == null || expression.length() == 0) return expression;
        Stack<Character> expressionTermsStack = new Stack<>();
        for(int i = expression.length() -1 ; i >=0 ; i--){
            Character crt = expression.charAt(i);
            if(!expressionTermsStack.isEmpty() && expressionTermsStack.peek() == '?'){
                expressionTermsStack.pop(); //pops ?
                Character trueCondition = expressionTermsStack.pop();
                expressionTermsStack.pop(); //pops :
                Character falseCondition = expressionTermsStack.pop();
                if(crt=='T'){
                    expressionTermsStack.push(trueCondition);
                }else expressionTermsStack.push(falseCondition);

            }else{
                expressionTermsStack.push(crt);
            }
        }
        return String.valueOf(expressionTermsStack.peek());
    }

    public String parseTernaryDFS(String expression) {
        if(expression == null || expression.length() == 0){
            return expression;
        }
        return DFS(expression, 0, expression.length() - 1) + "";

    }
    public char DFS(String exp, int start, int end){
        if(start == end){
            return exp.charAt(start);
        }
        int count = 0, i;
        for(i =start; i <= end; i++){
            if(exp.charAt(i) == '?'){
                count ++;
            }else if (exp.charAt(i) == ':'){
                count --;
                if(count == 0){
                    break;
                }
            }
        }
        return exp.charAt(start) == 'T'? DFS(exp, start + 2, i - 1) : DFS(exp, i+1, end);
    }

    public static void main(String[] args) {
        TernaryExpressionParser obj = new TernaryExpressionParser();
        System.out.println(obj.parseTernary("T?2:3"));
        System.out.println(obj.parseTernaryDFS("F?1:T?4:5"));
        System.out.println(obj.parseTernary("T?T?F:5:3"));
    }

}
