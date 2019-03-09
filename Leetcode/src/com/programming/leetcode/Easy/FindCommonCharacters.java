package com.programming.leetcode.Easy;

import java.util.ArrayList;

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

    public static void main(String[] args) {
        FindCommonCharacters obj = new FindCommonCharacters();
        System.out.println(obj.commonChars(new String[]{"bella","label","roller"}));
    }

}
