package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        Map<Character, Integer> charPos = new HashMap<>();
        int i = 0, begin = 0, maxLength =Integer.MIN_VALUE, count=0;
        while(i < s.length()){
            char crt = s.charAt(i);
            if(charPos.size() < 2 || charPos.containsKey(crt)){
                charPos.put(crt,charPos.getOrDefault(crt,0)+1);
                i++;
                maxLength = Math.max(maxLength, i-begin);
            }else{
                while(charPos.size()==2){
                    char ch = s.charAt(begin);
                    charPos.put(ch, charPos.get(ch)-1);
                    if(charPos.get(ch) == 0) {
                        charPos.remove(ch);
                    }
                    begin++;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtmostTwoDistinctCharacters obj = new LongestSubstringWithAtmostTwoDistinctCharacters();
        System.out.println(obj.lengthOfLongestSubstringTwoDistinct("eecccceeecbeeeeeeeeeeee"));
    }
}
