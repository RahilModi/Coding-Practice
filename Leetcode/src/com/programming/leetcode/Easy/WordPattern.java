package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {

        String[] inputArr = str.split(" ");
        char[] patternArr = pattern.toCharArray();
        if(inputArr.length != patternArr.length) return false;
        Map<Character,String> patternWordMap = new HashMap<>();
        Set<String> words = new HashSet<>();
        for(int i = 0; i < patternArr.length;i++){
            if(patternWordMap.isEmpty() || !patternWordMap.containsKey(patternArr[i])){
                if(!words.add(inputArr[i])){
                    return false;
                }
                patternWordMap.put(patternArr[i],inputArr[i]);
            }
            else{
                if(!patternWordMap.get(patternArr[i]).equals(inputArr[i])) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        WordPattern obj = new WordPattern();
        System.out.println(obj.wordPattern("abba","dog cat cat dog"));
        System.out.println(obj.wordPattern("abba", "dog cat cat fish"));
        System.out.println(obj.wordPattern("abba","dog dog dog dog"));
    }

}
