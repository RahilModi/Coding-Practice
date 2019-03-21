package com.programming.leetcode.Medium;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1 > len2) return false;
        int [] letterCount = new int[26];
        for(int i = 0; i < len1; i++){
            letterCount[s1.charAt(i)-'a']++;
            letterCount[s2.charAt(i)-'a']--;
        }
        if(isAllZero(letterCount)) return true;

        for(int i = len1; i <len2; i++){
            letterCount[s2.charAt(i)-'a']--;
            letterCount[s2.charAt(i-len1)-'a']++;
            if(isAllZero(letterCount)) return true;
        }
        return false;
    }

    private boolean isAllZero(int[] lettersFreq){
        for(int i : lettersFreq){
            if(i!=0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        PermutationInString obj = new PermutationInString();
        System.out.println(obj.checkInclusion("ab","eidbaooo"));
    }

}

