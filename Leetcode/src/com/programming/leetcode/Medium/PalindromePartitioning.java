package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        palindromePartitionerHelper(res, s, 0, new ArrayList<>());
        return res;
    }

    public void palindromePartitionerHelper(List<List<String>> res, String str, int pos, List<String> crt){
        if(pos == str.length()){
            res.add(new ArrayList<>(crt));
        }
        for(int i = pos; i<str.length(); i++){
            if(isPalindrom(str.substring(pos,i+1))) {
                crt.add(str.substring(pos, i+1));
                palindromePartitionerHelper(res,str,i+1,crt);
                crt.remove(crt.size()-1);
            }
        }
    }

    public boolean isPalindrom(String str){
        if(str.length()==1) return true;
        int mid_pos = str.length()%2==0 ? str.length()/2 : (str.length()+1)/2;
        for(int i = 0, j = str.length()-1; j >= mid_pos; j--,i++){
            if(str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        System.out.println(obj.partition("aab"));
    }

}
