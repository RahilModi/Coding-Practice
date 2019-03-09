package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubStringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        int begin, end, maxLen;
        begin = end = maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        boolean counter = false;
        while(end<s.length()){
            char crt = s.charAt(end++);
            map.put(crt, map.getOrDefault(crt,0)+1);
            if(map.get(crt) > 1){
                counter = true;
            }
            while(counter){
                char c = s.charAt(begin);
                if(map.get(c) > 1){
                    map.put(c, map.get(c)-1);
                    counter = false;
                }else{
                    map.remove(c);
                }
                begin++;
            }
            maxLen = Math.max(end-begin, maxLen);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubStringWithoutRepeating obj = new LengthOfLongestSubStringWithoutRepeating();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }
}
