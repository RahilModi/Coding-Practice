package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    class finder{
         int firstPos;
         boolean isrepeat;

        public finder(int pos, boolean repeat){
            this.firstPos = pos;
            this.isrepeat = repeat;
        }


    }

    public int firstUniqChar(String s) {
        Map<Character, finder> charMap = new HashMap<>();
        int index = 0;
        for(Character ch : s.toCharArray()){
            if (!charMap.containsKey(ch)){
                charMap.put(ch, new finder(index++, false));
            }else{
                finder obj = charMap.get(ch);
                obj.isrepeat = true;
                charMap.put(ch, obj);
            }
        }
        int lowerPos = Integer.MAX_VALUE ;
        boolean bSingleFound = false;
        for(Character ch : charMap.keySet()){
            if(!charMap.get(ch).isrepeat){
                bSingleFound = true;
                lowerPos = Math.min(lowerPos, charMap.get(ch).firstPos);
            }
        }

        return bSingleFound ? lowerPos : -1;
    }


    public int firstUniqCharAlternative(String s){
        int[] charArray = new int[26];
        for(char ch : s.toCharArray()){
            charArray[ch - 'a']++;
        }

        int index = 0;
        for(char ch : s.toCharArray()){
            if(charArray[ch - 'a'] == 1){
                return index;
            }
            index++;
        }
        return index == s.length() ? -1 : index;
    }


    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterInString().firstUniqChar("loveleetcode"));
    }
}
