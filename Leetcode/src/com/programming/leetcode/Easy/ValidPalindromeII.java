package com.programming.leetcode.Easy;


public class ValidPalindromeII {

    public boolean validityChecker(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if(s==null || s.length() <= 1)return true;
        int l = 0, r = s.length()-1;
        while (l < r){
            if(s.charAt(l) != s.charAt(r)){
                return validityChecker(s,l+1,r) || validityChecker(s,l,r-1);
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII obj = new ValidPalindromeII();
        System.out.println(obj.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(obj.validPalindrome("deeee"));
        System.out.println(obj.validPalindrome("abca"));
        System.out.println(obj.validPalindrome("aba"));
        System.out.println(obj.validPalindrome("teebbm"));
    }
}
