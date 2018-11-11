package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        new RemoveInvalidParantheses().removeInvalidParentheses("()())()");
    }
}
