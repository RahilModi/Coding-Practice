package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class originalDigits {

    //TLE......
    public String originalDigits(String s) {

        String[] words = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }

        List<Integer> digits = new ArrayList<>();
        int count = 0;
        while (count < s.length()) {
            for (int i = 0; i <words.length; i++) {
                String w = words[i];
                int idx = 0;
                for(char c : w.toCharArray()){
                    if(freq[c-'a'] == 0){
                        break;
                    }
                    freq[c-'a']--;
                    idx++;
                }
                if(idx != w.length()){
                    for(int j = 0; j < w.length() && j < idx; j++)
                        freq[w.charAt(j)-'a']++;
                }else {
                    count += w.length();
                    digits.add(i);
                }
            }
        }

        Collections.sort(digits);
        StringBuilder sb = new StringBuilder();
        for(Integer i : digits){
            sb.append(i);
        }
        return sb.toString();

    }

    public String originalDigitsV1(String s) {
        int[] count = new int[10];
        for(char c : s.toCharArray()){
            if(c == 'z') count[0]++;
            else if(c == 'x') count[6]++;
            else if(c == 'g') count[8]++;
            else if(c == 'f') count[5]++;
            else if(c == 'w') count[2]++;
            else if(c == 's') count[7]++;
            else if(c == 'i') count[9]++;
            else if(c == 'o') count[1]++;
            else if(c == 'u') count[4]++;
            else if(c == 'h') count[3]++;
        }
        count[7] -= count[6];
        count[3] -= count[8];
        count[5] -= count[4];
        count[9] = count[9] - count[8] - count[5] -count[6];
        count[1] = count[1] - count[2] - count[0] - count[4];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<= 9; i++){
            for(int j = 0; j < count[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        originalDigits obj = new originalDigits();
        System.out.println(obj.originalDigits("owoztneoer"));
    }

}
