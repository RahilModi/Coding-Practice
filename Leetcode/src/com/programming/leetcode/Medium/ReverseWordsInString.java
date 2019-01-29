package com.programming.leetcode.Medium;

public class ReverseWordsInString {

    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s");
        StringBuilder bld = new StringBuilder();
        for(int i = arr.length-1; i >=0; i--) {
            if(!arr[i].isEmpty()) {
                if (i != arr.length - 1)
                    bld.append(" ");
                bld.append(arr[i]);
            }
        }
        return bld.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInString obj = new ReverseWordsInString();
        System.out.println(obj.reverseWords("the  sky is   blue"));
    }
}
