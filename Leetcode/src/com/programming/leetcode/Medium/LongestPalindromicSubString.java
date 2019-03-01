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


    int left = 0, maxLen = 0;
    public String longestPalindromeV1(String s) {
        if(s == null || s.length() < 2) return s;
        for(int i = 0; i < s.length()-1; i++){
            extendsValid(s, i, i);
            extendsValid(s, i, i+1);
        }
        return s.substring(left, left+maxLen);
    }

    public void extendsValid(String s, int l, int r){
        while(r < s.length() && l >= 0 && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        if(maxLen < r - l -1 ){
            left = l+1;
            maxLen = r-l-1;
        }
    }
}
