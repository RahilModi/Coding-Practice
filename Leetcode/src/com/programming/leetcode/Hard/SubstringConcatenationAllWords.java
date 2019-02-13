package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenationAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s==null || s.isEmpty() || words == null || words.length == 0) return res;
        Map<String,Integer> wordsFreq = new HashMap<>();
        for(String  w : words) wordsFreq.put(w,wordsFreq.getOrDefault(w,0)+1);
        int wordLength = words[0].length();
        int totalWords = words.length;
        for(int i = 0; i < s.length() - (wordLength * totalWords) + 1; i++){
            Map<String, Integer> crt_turn_freq = new HashMap<>();
            int j = 0;
            while( j < totalWords){
                final String word = s.substring(i+j*wordLength,i+(j+1)*wordLength);
                if(wordsFreq.containsKey(word)){
                    crt_turn_freq.put(word,crt_turn_freq.getOrDefault(word,0)+1);
                    if(crt_turn_freq.get(word) > wordsFreq.getOrDefault(word,0)){
                        break;
                    }
                    j++;
                }else{
                    break;
                }
            }
            if(j == totalWords) {
                res.add(i);
            }
        }
        return res;
    }

}
