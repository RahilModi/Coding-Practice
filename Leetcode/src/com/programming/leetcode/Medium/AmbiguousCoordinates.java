package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        if(S == null || S.isEmpty()) return res;
        S = S.substring(1,S.length()-1);
        for(int i = 1; i < S.length(); i++){
            for(String ls : helper(S.substring(0,i))){
                for(String rs : helper(S.substring(i))){
                    res.add("("+ls+", "+rs+")");
                }
            }
        }
        return res;
    }

    private List<String> helper(String input){
        List<String> res = new ArrayList<>();
        if(input.length() == 1){ res.add(input);return res; }
        if(input.charAt(0) == '0' && input.charAt(input.length()-1) == '0') return res;
        if(input.charAt(0) == '0') {res.add("0."+input.substring(1)); return res;}
        if(input.charAt(input.length()-1) == '0') {res.add(input); return res;}
        res.add(input);
        for(int i=1;i <input.length(); i++){
            res.add(input.substring(0,i)+"."+input.substring(i));
        }
        return res;
    }

    public static void main(String[] args) {
        AmbiguousCoordinates obj = new AmbiguousCoordinates();
        System.out.println(obj.ambiguousCoordinates("(123)"));
        System.out.println(obj.ambiguousCoordinates("(00111)"));
    }
}
