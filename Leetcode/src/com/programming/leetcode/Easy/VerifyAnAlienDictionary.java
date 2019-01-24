package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class VerifyAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {

        int[] sorted = new int[26];
        int index = 26;
        for(char c: order.toCharArray()){
            sorted[c-'a'] = index--;
        }

        for(int i = 1; i < words.length; i++){
            String str = words[i-1], str2 = words[i];
            boolean bMisMatch = false;
            int j = 0;
            for(; j < Math.min(str.length(),str2.length()); j++){
                char c1 = str.charAt(j), c2 =str2.charAt(j);
                if(c1 != c2) {
                    if (sorted[c1 - 'a'] < sorted[c2 - 'a']) return false;
                    else {
                        bMisMatch = true;
                        break;
                    }
                }
            }
            if(!bMisMatch && j < str.length()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyAnAlienDictionary obj = new VerifyAnAlienDictionary();
        System.out.println(obj.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(obj.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(obj.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
