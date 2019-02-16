package com.programming.leetcode.Easy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidWordSquares {
    public boolean validWordSquare(List<String> words) {
        if(words == null || words.isEmpty() || words.size() != words.get(0).length()) return false;
        int n = words.size();;
        for(int i = 0; i < words.size(); i++){
            for(int j = 0; j < words.get(i).length(); j++){
                if(j >= n || words.get(j).length() <= i || words.get(i).charAt(j) != words.get(j).charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("ball","asee","let","lep");
        System.out.println(new ValidWordSquares().validWordSquare(input));
    }

}
