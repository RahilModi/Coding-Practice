package com.programming.leetcode.Easy;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;


public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        if(A == null ||A.length ==0) return new ArrayList<>();
        int[] letters = new int[26];
        char[] charArr = A[0].toCharArray();
        for(char c : charArr)letters[c-'a']++;
        int[] copyLetters  = new int[26];
        System.arraycopy(letters,0,copyLetters,0,letters.length);
        for(int i =1 ; i < A.length; i++){
            for(char c : A[i].toCharArray()){
                if(letters[c-'a'] > 0){
                    letters[c-'a']--;
                }
            }
            for(int j= 0; j < copyLetters.length; j++){
                letters[j] = copyLetters[j]-letters[j];
            }

            System.arraycopy(letters,0,copyLetters,0,letters.length);
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i < letters.length; i++){
            while (letters[i]-->0){
                res.add(String.valueOf((char) (i+'a')));
            }
        }
        return res;
    }

    public List<String> commonCharsV1(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] cnt = new int[26];
            for (char c : str.toCharArray()) { ++cnt[c - 'a']; } // count each char's frequency in string str.
            for (int i = 0; i < 26; ++i) { count[i] = Math.min(cnt[i], count[i]); } // update minimum frequency.
        }
        for (int i = 0; i < 26; ++i) {
            while (count[i]-- > 0) { ans.add("" + (char)(i + 'a')); }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindCommonCharacters obj = new FindCommonCharacters();
        System.out.println(obj.commonChars(new String[]{"bella","label","roller"}));
    }

}
