package com.programming.leetcode.Medium;

import java.util.Collections;
import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {

        if(s==null || s.isEmpty() )return s;
        Stack<Integer>count = new Stack<>();
        Stack<String>stack = new Stack<>();
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx<s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int num = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    num = 10 * num + (s.charAt(idx)-'0');
                    idx++;
                }
                count.push(num);
            }else if(s.charAt(idx) == '['){
                stack.push(sb.toString());
                sb.setLength(0);
                idx++;
            }else if(s.charAt(idx)==']'){
                StringBuilder temp = new StringBuilder(stack.pop());
                temp.append(String.join("",Collections.nCopies(count.pop(), sb.toString())));
                sb = temp;
                idx++;
            }else{
                sb.append(s.charAt(idx++));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString obj = new DecodeString();
        System.out.println(obj.decodeString("3[a]2[bc]"));
    }

}
