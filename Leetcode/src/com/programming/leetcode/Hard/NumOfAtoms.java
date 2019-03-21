package com.programming.leetcode.Hard;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class NumOfAtoms {

    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        int N = formula.length();
        for(int i = 0;i<N;){
            char crt = formula.charAt(i);
            if(crt == '('){
                stack.push(new TreeMap<>());
                i++;
            }else if(crt == ')'){
                Map<String, Integer> map = stack.pop();
                i++;
                int num = 0;
                while (i < N && Character.isDigit(formula.charAt(i))) num = num *10 + (formula.charAt(i++)-'0');
                num = num == 0 ? 1 : num;
                for(String key : map.keySet())
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0)+num * map.get(key));
            }else {
                int prevIndex = i++;
                while(i < N && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(prevIndex, i);
                int num = 0;
                while (i < N && Character.isDigit(formula.charAt(i))) num = num *10 + (formula.charAt(i++)-'0');
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + (num == 0 ? 1 : num));
            }
        }
        StringBuilder res = new StringBuilder();
        for(String atom : stack.peek().keySet()){
            res.append(atom).append(stack.peek().get(atom) > 1 ? ""+stack.peek().get(atom) : "");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        NumOfAtoms obj = new NumOfAtoms();
        System.out.println(obj.countOfAtoms("H11He49NO35B7N46Li20"));
//        System.out.println(obj.countOfAtoms("H2O"));
//        System.out.println(obj.countOfAtoms("H2O2He3Mg4"));
        System.out.println(obj.countOfAtoms("K4(ON(SO3)2)2"));
    }

}
