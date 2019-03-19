package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingWord {
    public int minimumLengthEncoding(String[] words) {
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        for(String s : words){
            for(int i = 1; i<s.length(); i++){
                dict.remove(s.substring(i));
            }
        }
        int res = 0;
        for(String w : dict) res += w.length()+1;
        return res;
    }

    public static void main(String[] args) {

        ShortEncodingWord obj= new ShortEncodingWord();
        System.out.println(obj.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }
}
