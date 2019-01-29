package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity {

    public  boolean isSentenceSimilar(String[] words1, String[] words2, String[][] pairs){
        if(words1.length != words2.length) return false;
        Map<String, Set<String>> similarWords = new HashMap<>();
        for(String[] pair : pairs){
            Set<String> similar = similarWords.getOrDefault(pair[0],new HashSet<String>());
            similar.add(pair[1]);
            similarWords.put(pair[0],similar);

            similar = similarWords.getOrDefault(pair[1],new HashSet<String>());
            similar.add(pair[0]);
            similarWords.put(pair[1],similar);
        }

        for(int i = 0; i < words1.length; i++){
            if(words1[i].equals(words2[i])) continue;
            if(similarWords.get(words1[i]) == null || !similarWords.get(words1[i]).contains(words2[i])) return false;
        }
        return true;
    }
}
