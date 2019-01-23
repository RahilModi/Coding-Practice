package com.programming.leetcode.Hard;

import java.util.*;

public class WordPatternII {

    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character,String> patternWordMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        boolean res =  wordPatternMatcherUtil(pattern,0,str,0,wordSet,patternWordMap);
        System.out.println(Arrays.toString(patternWordMap.values().toArray()));
        return res;
    }

    public boolean wordPatternMatcherUtil(String pattern, int pos1, String str, int pos2, Set<String> set, Map<Character, String> map){
        if(pos1 == pattern.length()) return pos2 == str.length();
        if(pos1 == pattern.length() || pos2 == str.length()) return false;
        char crt_pattern_char = pattern.charAt(pos1);
        if(map.containsKey(crt_pattern_char)){
            String str_1 = map.get(crt_pattern_char);
            if(!str.startsWith(str_1,pos2)){
                return false;
            }
            return wordPatternMatcherUtil(pattern,pos1+1,str,pos2+str_1.length(), set, map);
        }
        for(int i = pos2; i < str.length() - (pattern.length()-pos1-1); i++) {
            String crt_str = str.substring(pos2, i + 1);
            if (set.contains(crt_str)) continue;
            set.add(crt_str);
            map.put(crt_pattern_char, crt_str);
            if (wordPatternMatcherUtil(pattern, pos1 + 1, str, i + 1, set, map)) {
                return true;
            }
            set.remove(crt_str);
        }
        map.remove(crt_pattern_char);
        return false;
    }


    public static void main(String[] args) {
        WordPatternII obj = new WordPatternII();
        System.out.println(obj.wordPatternMatch("abab","redblueredblue"));
        System.out.println(obj.wordPatternMatch("aabb","xyzabcxzyabc"));
    }
}
