package com.programming.leetcode.Medium;

public class LongestPalindromicSubString {

    public String longestPalindromeSubstring(String S){
        if(S == null || S.length() < 2) return S;
        int max = Integer.MIN_VALUE;
        String res = "";
        for(int i = 0; i < S.length() ; i++){
            int l1 = findPalindrome(S, i, i);
            int l2 = findPalindrome(S, i, i+1);
            int crtMax = Math.max(l1,l2);
            if(crtMax >= max){
                if(l1 == crtMax){
                    res = S.substring(i - crtMax/2, i + crtMax/2);
                }else{
                    res = S.substring(i - crtMax/2 , i + crtMax/2 +1);
                }
            }
        }
        return res;
    }

    private int findPalindrome(String str, int i, int j){
        while (i >= 0 && j <= str.length() && str.charAt(i) == str.charAt(j)){
            i++;
            j--;
        }
        return j-i-1;
    }
}
