package com.programming.leetcode.Medium;
import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (num==null) return num;
        if(k==0) return num;
        if(k == num.length()) return "0";

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while ( i < num.length()){
            while (k>0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i)); //1432219
            i++;
        }

        while (k-->0){
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())sb.append(stack.pop());
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits obj = new RemoveKDigits();
        System.out.println(obj.removeKdigits("142139",3));
    }

}
