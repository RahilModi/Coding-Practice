package com.programming.leetcode.Medium;

import java.util.Stack;

public class MinimumAddToMakeParanthesesValid {

    public int minAddToMakeValid(String S) {
        if(S==null || S.isEmpty()) return 0;
        Stack<Character> stack = new Stack<>();
        int counter = 0;
        for(int i = 0; i<S.length() ; i++){
            char crt = S.charAt(i);
            if(crt=='(') stack.push(crt);
            else {
                if (stack.isEmpty()) counter++;
                else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            stack.pop();
            counter++;
        }

        return counter;
    }

    public int minAddToMakeValidII(String S) {
        int ans = 0, bal = 0;
        for(char c : S.toCharArray()){
            if(bal == 0 && c==')'){
                ans++;
            }
            else{
                bal += c == '(' ? 1 : -1;
            }
        }
        return ans+bal;
    }


    public static void main(String[] args) {
        System.out.println(new MinimumAddToMakeParanthesesValid().minAddToMakeValid("()))"));
        System.out.println(new MinimumAddToMakeParanthesesValid().minAddToMakeValid("((()))"));
        System.out.println(new MinimumAddToMakeParanthesesValid().minAddToMakeValid("))))"));
        System.out.println(new MinimumAddToMakeParanthesesValid().minAddToMakeValid("((()()"));
        System.out.println(new MinimumAddToMakeParanthesesValid().minAddToMakeValidII("()))"));
        System.out.println(new MinimumAddToMakeParanthesesValid().minAddToMakeValidII("((()))"));
        System.out.println(new MinimumAddToMakeParanthesesValid().minAddToMakeValidII("))))"));
        System.out.println(new MinimumAddToMakeParanthesesValid().minAddToMakeValidII("((()()"));

    }

}
