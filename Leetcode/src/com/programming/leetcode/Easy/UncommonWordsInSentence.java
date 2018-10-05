package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsInSentence {

    public static String[] uncommonFromSentences(String A, String B) {
        if(A.isEmpty() && B.isEmpty()) return new String[]{};
        if(A.isEmpty()) return B.split(" ");
        if(B.isEmpty()) return A.split(" ");

        Map<String, Integer> wordCount = new HashMap<>();
        for(String word : A.split(" ")){
            wordCount.put(word, wordCount.getOrDefault(word,0)+1);
        }

        for(String word : B.split(" ")){
            wordCount.put(word, wordCount.getOrDefault(word,0)+1);
        }

        List<String> ans = new ArrayList<>();
        for(String key : wordCount.keySet()){
            if(wordCount.get(key) < 2){
                ans.add(key);
            }
        }

        return ans.toArray(new String[ans.size()]);

    }

    public static void main(String[] args) {

        String[] res = UncommonWordsInSentence.uncommonFromSentences("this apple is sweet",  "this apple is sour");
        for(String word: res){
            System.out.println(word);
        }

    }
}
