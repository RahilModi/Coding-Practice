package com.programming.leetcode.Hard;

import java.util.Stack;

public class LongestValidParantheses {

    public int longestValidParentheses(String s) {

        int[] dp = new int[s.length()];
        int maxlen = 0;
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(c==')'){
                if(s.charAt(i-1) =='('){
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                }else if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1) =='('){
                    dp[i] = dp[i-1] + ((i-dp[i-1]) >= 2 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
                maxlen = Math.max(maxlen, dp[i]);
            }
        }
        return maxlen;
    }

    public boolean isValidParantheses(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public int longestValidParenthesesBruteForce(String s) {
        int maxLen = 0;
        for(int i = 0; i < s.length() ; i++){
            for(int j = i+2 ; j <= s.length() ; j+=2){
                if(isValidParantheses(s.substring(i,j))){
                    maxLen = Math.max(maxLen, j -i);
                }
            }
        }
        return maxLen;
    }

    public int longestValidParenthesesUsingStack(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    maxlen = Math.max(maxlen, i - stack.peek());
                }
            }
        }
        return maxlen;
    }



    public static void main(String[] args) {
        LongestValidParantheses obj = new LongestValidParantheses();
        System.out.println(obj.longestValidParentheses("(()())"));
        System.out.println(obj.longestValidParentheses("((((()())"));
        System.out.println(obj.longestValidParentheses("())))()())"));
        System.out.println(obj.longestValidParentheses("(()()()()())"));
        System.out.println(obj.longestValidParenthesesBruteForce("(()())"));
        System.out.println(obj.longestValidParenthesesBruteForce("((((()())"));
        System.out.println(obj.longestValidParenthesesBruteForce("())))()())"));
        System.out.println(obj.longestValidParenthesesBruteForce("(()()()()())"));
        System.out.println(obj.longestValidParenthesesUsingStack("(()())"));
        System.out.println(obj.longestValidParenthesesUsingStack("((((()())"));
        System.out.println(obj.longestValidParenthesesUsingStack("())))()())"));
        System.out.println(obj.longestValidParenthesesUsingStack("(()()()()())"));

    }
}
