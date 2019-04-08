package com.programming.leetcode.Hard;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        if(t.length() > s.length()) return "";
        for(char c : t.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        int count = charCountMap.size(),len =Integer.MAX_VALUE,left, i, begin;
        left = i = begin = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(charCountMap.containsKey(c)){
                charCountMap.put(c,charCountMap.get(c)-1);
                if(charCountMap.get(c) == 0) count--;
            }
            i++;
            while(count == 0){
                char temp = s.charAt(left);
                if(charCountMap.containsKey(temp)){
                    charCountMap.put(temp, charCountMap.get(temp) + 1);
                    if(charCountMap.get(temp) > 0) count++;
                }
                if(i - left < len){
                    len = i - left;
                    begin = left;
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(begin,begin+len);
    }

}
