package com.programming.leetcode.Hard;

import java.util.*;

public class RemoveInvalidParantheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(s,0,0,res, new char[]{'(',')'});
        return res;
    }

    private void helper(String str, int a, int b, List<String> res, char[] parantheses){
        for(int k = 0, i = a; i<str.length(); ++i){
            if(str.charAt(i)==parantheses[0])k++;
            if(str.charAt(i)==parantheses[1])k--;
            if(k >= 0) continue;
            for(int j = b; j <= i;++j){
                if(str.charAt(j)==parantheses[1] && (j == b || str.charAt(j-1)!=parantheses[1]))
                    helper(str.substring(0,j)+str.substring(j+1),i,j,res,parantheses);
            }
            return;
        }
        String reversed = new StringBuilder(str).reverse().toString();
        if(parantheses[0]=='('){
            helper(reversed, 0,0,res,new char[]{')','('});
        }else{
            res.add(reversed);
        }
    }


    public List<String> removeInvalidParenthesesBFS(String s) {

        if(s == null) return null;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean bFound =false;
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()){
            String crt = queue.poll();
            if(isValid(crt)){
                bFound = true;
                res.add(crt);
            }
            if(bFound) continue;

            for(int i = 0; i < crt.length(); i++){
                if (crt.charAt(i) != '(' && crt.charAt(i) != ')') continue;
                String sub = crt.substring(0,i) + crt.substring(i+1);
                if(!visited.contains(sub)){
                    visited.add(sub);
                    queue.offer(sub);
                }
            }
        }

        return res;

    }

    public boolean isValid(String s){
        int counter = 0;
        for(char c : s.toCharArray()){
            if(c == '(') counter++;
            else if(c == ')' && counter-- == 0)  return false;
        }
        return counter == 0;
    }

    public static void main(String[] args) {

        System.out.println(new RemoveInvalidParantheses().removeInvalidParenthesesBFS("()())()"));

        new RemoveInvalidParantheses().removeInvalidParentheses("()())()");
    }
}
