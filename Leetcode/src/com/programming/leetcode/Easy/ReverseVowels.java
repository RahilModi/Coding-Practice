package com.programming.leetcode.Easy;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int start = 0 , end = s.length() -1;
        char[] arr = s.toCharArray();
        while (start < end){
            while(start < end && !vowels.contains(s.charAt(start))){
                start++;
            }
            while(start < end && !vowels.contains(s.charAt(end))){
                end--;
            }
            if(start < end)
                swap(arr,start,end);
            start++;
            end--;
        }
        return new String(arr);
    }

    private void swap(char[] input, int a, int b){
        char temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public static void main(String[] args) {

        ReverseVowels obj = new ReverseVowels();
        System.out.println(obj.reverseVowels("leetcode"));

    }
}
