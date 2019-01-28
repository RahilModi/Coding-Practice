package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipGame {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '+' && s.charAt(i) == s.charAt(i-1)){
                res.add(s.substring(0,i-1)+"--"+ s.substring(i+1));
            }
        }
        System.out.println(Arrays.toString(res.toArray(new String[res.size()])));
        return res;
    }

    public static void main(String[] args) {
        new FlipGame().generatePossibleNextMoves("++++++");
    }
}
