package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(Character ch : magazine.toCharArray()){
            charCount.put(ch, charCount.getOrDefault(ch,0)+1);
        }

        for(Character ch : ransomNote.toCharArray()){
            if(!charCount.containsKey(ch)) return false;
            else{
                int count = charCount.get(ch);
                if(count == 1) charCount.remove(ch);
                else charCount.put(ch, --count);
            }
        }

        return true;

    }

    public boolean canConstructV2(String ransomNote, String magazine) {
        int[] dict = new int[26];
        for(Character ch : magazine.toCharArray()){
            dict[ch-'a']++;
        }

        for(Character ch : ransomNote.toCharArray()){
            dict[ch-'a']--;
            if(dict[ch-'a'] < 0) return false;
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("fffbfg",
                "effjfggbffjdgbjjhhdegh"));
    }
}
