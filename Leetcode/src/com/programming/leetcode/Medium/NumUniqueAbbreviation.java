package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumUniqueAbbreviation {

    Map<String, Set<String>> abbreviations = new HashMap<>();
    public NumUniqueAbbreviation(String[] dictionary) {
        if(dictionary == null || dictionary.length == 0) return;
        for(String str : dictionary){
            String abrev = str.length() <= 2 ? str : str.charAt(0) +""+ (str.length()-2)+""+ str.charAt(str.length()-1);
            if(abbreviations.get(abrev) == null){
                abbreviations.put(abrev, new HashSet<>());
            }
            abbreviations.get(abrev).add(str);
        }
    }

    public boolean isUnique(String word) {
        if(word == null ) return false;
        String crtAbrev = word.length() <= 2 ? word : word.charAt(0) +""+ (word.length()-2)+""+ word.charAt(word.length()-1);
        if(abbreviations.containsKey(crtAbrev)) {
            if (abbreviations.get(crtAbrev).contains(word) && abbreviations.get(crtAbrev).size() == 1) {
                return true;
            } else {
                return false;
            }
        }else return true;
    }

}
