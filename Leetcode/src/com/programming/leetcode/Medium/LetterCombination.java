package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

    static Map<Character, String> digitCharMapping = new HashMap<>();
    {
        digitCharMapping.put('2',"abc");
        digitCharMapping.put('3',"def");
        digitCharMapping.put('4',"ghi");
        digitCharMapping.put('5',"jkl");
        digitCharMapping.put('6',"mno");
        digitCharMapping.put('7',"pqrs");
        digitCharMapping.put('8',"tuv");
        digitCharMapping.put('9',"wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits==null || digits.isEmpty()) return result;
        helper(digits, 0, result, new StringBuilder());
        return result;
    }

    private void helper(String seq, int index, List<String> result, StringBuilder strBld){
        if(index == seq.length()){
            result.add(strBld.toString());
            return;
        }
        if(index < seq.length()){
            String chars = digitCharMapping.get(seq.charAt(index));
            int j = 0;
            while(j< chars.length()) {
                strBld.append(chars.charAt(j++));
                helper(seq, index + 1, result, strBld);
                strBld.deleteCharAt(strBld.length() - 1);
            }
            index++;
        }
    }

    String[] digitsArr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinationsV1(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.isEmpty()) return res;
        backtrack(0, digits, res, new StringBuilder());
        return res;
    }

    private void backtrack(int crtIndex, String digits, List<String> r, StringBuilder crt){
        if(crtIndex == digits.length()){
            r.add(crt.toString());
            return;
        }
        for(char c : digitsArr[digits.charAt(crtIndex) - '0'].toCharArray()){
            backtrack(crtIndex+1, digits, r, crt.append(c));
            crt.deleteCharAt(crt.length()-1);
        }
    }

    public static void main(String[] args) {
        List<String> res = new LetterCombination().letterCombinations("234");
        for(String r :res) System.out.println(r);
    }
}
