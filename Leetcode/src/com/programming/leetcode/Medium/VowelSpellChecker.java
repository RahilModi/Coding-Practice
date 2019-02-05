package com.programming.leetcode.Medium;

import java.util.*;

public class VowelSpellChecker {

    Set<String> dict = new LinkedHashSet<>();
    public String[] spellchecker(String[] wordlist, String[] queries) {
        for(String word:wordlist) dict.add(word);
        String [] res = new String[queries.length];
        int idx = 0;
        for(String query : queries){
            boolean bFound = false;
            if(dict.contains(query)) {
                res[idx]=query;
            }else if(dict.contains(query.toLowerCase())) {
                for (String word : dict) {
                    if (word.equalsIgnoreCase(query)) {
                        res[idx] = word;
                        bFound = true;
                        break;
                    }
                }
            }else{
                if (!bFound) {
                    for (String word : dict) {
                        if (vowelChecker(word.toLowerCase(), query)) {
                            res[idx] = word;
                            bFound = true;
                            break;
                        }
                    }
                }
                if (!bFound) res[idx] = "";
            }
            idx++;
        }
        return res;
    }

    Set<Character> vowels = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
    public boolean vowelChecker(String word, String query){
        int i = 0, j = 0;
        while(i < word.length() && j < query.length()){
            char w = Character.toLowerCase(word.charAt(i));
            char q = Character.toLowerCase(query.charAt(j));
            if(w != q && !(vowels.contains(w) && vowels.contains(q)))
                return false;
            i++;
            j++;
        }
        return i==word.length() && j==query.length();
    }


    //Using two hashmapss......
    //much better solution...

    public String[] spellcheckerV1(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String, String> cap = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            String lower = w.toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(devowel, w);
        }
        for (int i = 0; i < queries.length; ++i) {
            if (words.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
            } else if (vowel.containsKey(devowel)) {
                queries[i] = vowel.get(devowel);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }

    public static void main(String[] args) {
        VowelSpellChecker obj =new VowelSpellChecker();
        String [] words = {"noi","nae","KiTe","kite","hare","Hare"};
        String [] queries = {"nAe","aiF","kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        System.out.println(Arrays.toString(obj.spellchecker(words,queries)));
    }
}
