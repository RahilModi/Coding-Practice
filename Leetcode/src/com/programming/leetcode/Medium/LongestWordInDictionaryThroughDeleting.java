package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a,b)-> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        int i;
        for(String w : d){
            i=0;
            for(char c : s.toCharArray()){
                if (i < w.length() && c == w.charAt(i)) i++;
                if (i >= w.length()) break;
            }
            if(i == w.length()) return w;
        }
        return "";
    }

    //Without Sorting..
    public String findLongestWordV1(String s, List<String> d) {
        int longestWordLength = 0;
        String ans = "";
        int i;
        for(String w : d){
            i=0;
            for(char c : s.toCharArray()) {
                if (i < w.length() && c == w.charAt(i)) i++;
                if (i >= w.length()) break;
            }
            if(i == w.length() && i >= longestWordLength){
                if(i == longestWordLength) ans = w.compareTo(ans) < 0 ? w : ans;
                else {
                    ans = w;
                    longestWordLength = i;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] dict = {"p","a","ale","apple","monkey","plea","appl"};
        LongestWordInDictionaryThroughDeleting obj = new LongestWordInDictionaryThroughDeleting();
        System.out.println(obj.findLongestWordV1("abpcplea", Arrays.asList(dict)));
        System.out.println(obj.findLongestWord("abpcplea", Arrays.asList(dict)));
    }

}
