package com.programming.leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class ExpressiveWords {

    public int expressiveWords(String S, String[] words) {
        StringBuilder sb = new StringBuilder();
        int ptr = 0;
        boolean[] letters = new boolean[26];
        for(int i = 0; i < S.length(); i++){
            letters[S.charAt(i)-'a'] = true;
            while (i < S.length() && S.charAt(i) == S.charAt(ptr)) {
                i++;
            }
            i--;
            sb.append(S.charAt(ptr)+"#");
            sb.append(i-ptr+1);
            ptr = i+1;
            if(i<S.length()-1){
                sb.append("#");
            }
        }
        String[] tokens = sb.toString().split("#");
        int ans =0;
        for(String word : words){
            int id = 0;
            for(int i = 0; i < word.length(); i++){
                if(letters[S.charAt(i)-'a'] && id < tokens.length-1 && tokens[id].charAt(0) == word.charAt(i)){
                    int num = Integer.parseInt(tokens[id+1]);
                    int count = 0;
                    while(i < word.length() && word.charAt(i) == tokens[id].charAt(0)){
                        i++;
                        count++;
                    }
                    if(count > num || (num < 3 && count!=num)) {
                        break;
                    }
                    i--;
                    id+=2;
                }else{
                    break;
                }
            }
            if(id == tokens.length) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ExpressiveWords obj = new ExpressiveWords();
        System.out.println(obj.expressiveWords("le", new String[]{"lee"}));
    }
}
