package com.programming.leetcode.Medium;

import java.util.Collections;
import java.util.StringJoiner;

public class CustomSortString {

    public String customSortString(String S, String T) {
        int[] letters = new int[26];
        for(char c: T.toCharArray()){
            letters[c-'a']++;
        }
        StringBuilder res = new StringBuilder();
        for(char c : S.toCharArray()){
            while(letters[c-'a']-->0)
                res.append(c);
        }
        int idx=0;
        for(int l : letters){
            while (l-->0){
                res.append((char)(idx+'a'));
            }
            idx++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        CustomSortString str = new CustomSortString();
        System.out.println(str.customSortString("cba","abswdcsdrt"));
    }

}
