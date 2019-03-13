package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class SplitStringIntoFibSequence {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        backtrack(S, 0, res);
        return res;
    }

    private boolean backtrack(String str, int idx, List<Integer>res){
        if(idx == str.length() && res.size() >= 3){
            return true;
        }
        for(int i = idx; i < str.length(); i++){
            if(str.charAt(idx) == '0' && i > idx) break;
            Long num = Long.parseLong(str.substring(idx, i+1));
            int crtSize = res.size();
            if(num > Integer.MAX_VALUE || (crtSize >= 2 && num > (res.get(crtSize-1) + res.get(crtSize-2)))){
                break;
            }
            if(crtSize <= 1 || num == (res.get(crtSize-1) + res.get(crtSize-2))){
                res.add(num.intValue());
                if(backtrack(str, i+1, res)){
                    return true;
                }
                res.remove(res.size()-1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SplitStringIntoFibSequence obj = new SplitStringIntoFibSequence();
        System.out.println( obj.splitIntoFibonacci( "123456579"));
    }

}
