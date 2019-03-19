package com.programming.leetcode.Hard;

import com.programming.leetcode.Medium.ShortEncodingWord;

public class ShortestPalindrome {

    public String shortestPalindrome(String s) {

        int j = 0, i = s.length()-1;
        while (i >= 0) {
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            i--;
        }
        if(j == s.length()) return s;
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0,j))+ suffix;

    }

    public static void main(String[] args) {
        ShortestPalindrome obj = new ShortestPalindrome();
        System.out.println(obj.shortestPalindrome("abcd"));
        System.out.println(obj.shortestPalindrome("aacecaaa"));
    }

}
