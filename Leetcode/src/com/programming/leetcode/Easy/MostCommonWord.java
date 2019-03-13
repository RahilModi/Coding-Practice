package com.programming.leetcode.Easy;

import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> bannedWords = new HashSet<>();
        bannedWords.addAll(Arrays.asList(banned));
        String[] words = paragraph.split("[\\s!?',;.]+");
        int maxCount =0;
        String res = "";
        for(String word : words ){
            if(bannedWords.contains(word)) continue;
            String lower  = word.toLowerCase();
            wordCount.put(lower, wordCount.getOrDefault(lower,0)+1);
            if(wordCount.get(lower) > maxCount){
                maxCount = wordCount.get(lower);
                res = lower;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        MostCommonWord obj = new MostCommonWord();
        System.out.println(obj.mostCommonWord("Bob hit a ball, the, hit, BALL, flew far after it was hit.", new String[]{"hit"}));
    }

}
