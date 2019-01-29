package com.programming.leetcode.Easy;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.length()-1;
        for(; i >= 0; i--){
            if(Character.isWhitespace(s.charAt(i))) break;
        }
        return s.length()-1-i;
    }

    public static void main(String[] args) {
        LengthOfLastWord obj = new LengthOfLastWord();
        System.out.println(obj.lengthOfLastWord("Hello Worlds"));
        System.out.println(obj.lengthOfLastWord("HelloWorlds"));
        System.out.println(obj.lengthOfLastWord("Hello Worlds "));
    }

}
