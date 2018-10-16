package com.programming.leetcode.Medium;

public class PalindromicSubStringCount {

    public int countSubstrings(String s) {
        StringBuilder Builder = new StringBuilder();
        int count = 0;
        for(int i = 0; i < s.length() ; i++){
            for(int j = i; j < s.length(); j++){
                Builder.append(s.charAt(j));
                if(isPalindromic(Builder.toString())){
                    count++;
                }
            }
            Builder.setLength(0);
        }
        return count;
    }

    private static boolean isPalindromic(String s){
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public int countSubstringsV2(String s) {
        int count = 0;
        if(s==null || s.length() == 0) return 0;

        for(int i = 0; i < s.length() ;i++){
            count = checkPalindrome(s, i, i, count);
            count = checkPalindrome(s, i , i+1,count);
        }
        return count;
    }

    private static int checkPalindrome(String s, int i, int j,int count){
        while( i>= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        PalindromicSubStringCount obj = new PalindromicSubStringCount();
        System.out.println(obj.countSubstrings("aba"));
        System.out.println(obj.countSubstringsV2("aba"));
    }
}
