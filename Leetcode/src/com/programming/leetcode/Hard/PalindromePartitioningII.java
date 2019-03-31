package com.programming.leetcode.Hard;

import com.programming.leetcode.Easy.MajorityElement;
import com.programming.leetcode.Medium.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningII {

    //Time Limit Exceeds...
    int min_length;
    public int minCut(String s) {
        min_length =s.length();
        palindromePartitionerHelper( s, 0, new ArrayList<>());
        return min_length;
    }

    public void palindromePartitionerHelper(String str, int pos, List<String> crt){
        if(pos == str.length()){
            min_length = Math.min(min_length,crt.size()-1);
        }
        for(int i = pos; i<str.length(); i++){
            if(isPalindrom(str.substring(pos,i+1))) {
                crt.add(str.substring(pos, i+1));
                palindromePartitionerHelper(str,i+1,crt);
                crt.remove(crt.size()-1);
            }
        }
    }

    public boolean isPalindromV1(String str){
        return new StringBuilder(str).reverse().toString().equals(str);
    }

    public boolean isPalindrom(String str){
        if(str.length()==1) return true;
        int mid_pos = str.length()%2==0 ? str.length()/2 : (str.length()+1)/2;
        for(int i = 0, j = str.length()-1; j >= mid_pos; j--,i++){
            if(str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }


    public int minCutDP(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++) dp[i] = i-1;

        for(int i = 0; i < n ; i++){
            for(int j = 0; i - j >= 0 && i + j < n && s.charAt(i-j) == s.charAt(i+j); j++){
                dp[i+j+1] = Math.min(dp[i+j+1], dp[i-j]+1);
            }
            for(int j = 1; i-j+1>=0 && i+j < n && s.charAt(i-j+1) == s.charAt(i+j); j++){
                dp[i+j+1] = Math.min(dp[i+j+1], dp[i-j+1]+1);
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        PalindromePartitioningII obj = new PalindromePartitioningII();
        System.out.println(obj.minCut("aab"));
    }
}
