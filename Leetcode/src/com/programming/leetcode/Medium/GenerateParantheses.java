package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParantheses {

    //O(2^2n) =>generate all possible combinations and then only add valid ones
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        helper(2 * n, 0, new char[2*n], result);
        return result;
    }

    private void helper(int n, int crt_indx, char[] combination, List<String> output){
        if(crt_indx == n){
            if(validator(new String(combination))){
                output.add(new String(combination));
            };
            return;
        }
        else{
            combination[crt_indx] = '(';
            helper(n, crt_indx + 1, combination, output);
            combination[crt_indx] = ')';
            helper(n, crt_indx + 1, combination, output);
        }
    }

    private boolean validator(String temp){
        int count = 0;
        for(char ch : temp.toCharArray()){
            if(ch == '(') count++;
            else count--;
            if(count < 0) return false;
        }
        return count == 0;
    }

    //Now don't create invalid combinations by keeping the count of '(' and ')'
    public List<String> generateParenthesisV2(int n) {

        List<String> result = new ArrayList<>();
        getCombinations(2 * n, n, "",0,0, result);
        return result;
    }

    private void getCombinations(int n, int max, String crt_pattern, int open, int close, List<String> output){
        if(crt_pattern.length() == n){
            output.add(crt_pattern);
            return;
        }else{
            if(open < max) getCombinations(n, max, crt_pattern + "(", open +1, close, output);
            if(close<open) getCombinations(n,max, crt_pattern+")",open, close+1, output);
        }
    }

    public List<String> generateParenthesisV3(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, "", res);
        return res;
    }
    private void backtrack(int n, String s, List<String> res){
        if(s.length() == 2*n ) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }

        backtrack(n, s+"(", res);
        backtrack(n, s+")", res);
    }

    private boolean isValid(String s){
        int count = 0;
        for(char c : s.toCharArray()){
            if(c=='(') count++;
            else if(c ==')' && --count < 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParantheses().generateParenthesisV3(3).size());
        System.out.println(new GenerateParantheses().generateParenthesis(3).size());
        List<String> combinations =new GenerateParantheses().generateParenthesisV2(3);
        for(String str :combinations) System.out.println(str);
    }

}
