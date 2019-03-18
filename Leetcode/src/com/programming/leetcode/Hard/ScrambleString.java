package com.programming.leetcode.Hard;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {

        if(s1.equals(s2)) return true;
        if(s1.length()!=s2.length()) return false;
        int[] charCount = new int[26];
        for(int i =0;i<s1.length();i++){
            charCount[s1.charAt(i)-'a']++;
            charCount[s2.charAt(i)-'a']--;
        }

        for(int i = 0; i< 26; i++) if(charCount[i] != 0) return false;

        for(int i = 1;i < s1.length();i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i))) return true;
            if(isScramble(s1.substring(0,i),s2.substring(s2.length()-i)) && isScramble(s1.substring(i),s2.substring(0,s2.length()-i)))return true;
        }
        return false;
    }

    public static void main(String[] args) {

        ScrambleString obj = new ScrambleString();
        System.out.println(obj.isScramble("great","eatrg"));
        System.out.println(obj.isScramble("abcde","caebd"));

    }
}
