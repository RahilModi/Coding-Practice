package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAbbreviations {

    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        res.add(word);
        helper(0,word,res);
        return res;
    }

    public void helper(int pos, String word, List<String> res){
        if(pos >= word.length()) return;
        for(int i = pos; i < word.length(); i++){
            for(int j =1; i+j<=word.length(); j++){
                String abbr = word.substring(0,i)+j+word.substring(i+j);
                res.add(abbr);
                helper(i+1+Integer.toString(j).length(), abbr, res);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GenerateAbbreviations().generateAbbreviations("word").toArray()));
    }
}
