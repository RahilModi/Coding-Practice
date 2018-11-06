package com.programming.leetcode.Medium;

import java.util.*;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String word : words){
            if(word.length()==pattern.length() && helperFunc(word, pattern)){
                res.add(word);
            }
        }
        return res;
    }

    private boolean helperFunc(String word, String pattern){
        Map<Character, Character> wordMap = new HashMap<>();
        Map<Character, Character> patternMap = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            wordMap.putIfAbsent(word.charAt(i), pattern.charAt(i));
            patternMap.putIfAbsent(pattern.charAt(i), word.charAt(i));
            if(wordMap.get(word.charAt(i))!=pattern.charAt(i) || patternMap.get(pattern.charAt(i)) != word.charAt(i)){
                return false;
            }
        }
        return true;
    }


    public List<String> findAndReplacePatternII(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        int[] p = helperFuncNormalized(pattern);
        for(String word : words){
            if(Arrays.equals(helperFuncNormalized(word), p)) res.add(word);
        }
        return res;
    }

    private int[] helperFuncNormalized( String word){
        Map<Character, Integer> normalized = new HashMap<>();
        int[] res = new int[word.length()];
        for(int i = 0; i < word.length(); i++){
            normalized.putIfAbsent(word.charAt(i), normalized.size());
            res[i] = normalized.get(word.charAt(i));
        }
        return res;
    }


    public static void main(String[] args) {
        new FindAndReplacePattern().findAndReplacePattern(new String[]{"mee", "bcc","ccc","dda"},"abb");
        new FindAndReplacePattern().findAndReplacePatternII(new String[]{"mee", "bcc","ccc","dda"},"abb");
    }


}
