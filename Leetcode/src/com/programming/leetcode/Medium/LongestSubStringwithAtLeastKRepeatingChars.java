package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringwithAtLeastKRepeatingChars {
    public int longestSubstring(String s, int k) {

        Map<Character, Integer> charPos = new HashMap<>();
        int i = 0, begin =0, max_length = 0;
        while(i < s.length()){
            char crt = s.charAt(i);
            charPos.put(crt,charPos.getOrDefault(crt,0)+1);
            i++;
            if(charPos.get(crt) >= k){
                Map<Character, Integer> tempMap = new HashMap<>();
                for(int m = 0; m <= i-k;m++){
                    char t = s.charAt(m);
                    if(charPos.get(t) >= k)
                    {
                        boolean bConditionSatisfied = true;
                        for(Character c: charPos.keySet()){
                            if(charPos.get(c) < k) {
                                bConditionSatisfied = false;
                                break;
                            }
                        }
                        if(bConditionSatisfied) {
                            max_length = Math.max(max_length, i - m);
                        }
                    }
                    charPos.put(t, charPos.get(t)-1);
                    tempMap.put(t, tempMap.getOrDefault(t,0)+1);
                    if(charPos.get(t)==0) charPos.remove(t);
                }
                for(Character key : tempMap.keySet()){
                    charPos.put(key, charPos.getOrDefault(key, 0) + tempMap.get(key));
                }
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        LongestSubStringwithAtLeastKRepeatingChars obj =  new LongestSubStringwithAtLeastKRepeatingChars();
        System.out.println(obj.longestSubstring("aabcabb",3));
        System.out.println(obj.longestSubstring("aacbbbda",2));
        System.out.println(obj.longestSubstring("aaaccccccsdeffbbbb",2));
        System.out.println(obj.longestSubstring("ababbc",2));

    }

}
