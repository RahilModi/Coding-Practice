package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNodeV3 {
    String word = null;
    HashMap<Character, TrieNodeV3> letters = new HashMap<>();
}

public class ReplaceWords {

    TrieNodeV3 dict = new TrieNodeV3();

    private void insertIntoDict(String word){
        TrieNodeV3 t = this.dict;
        for (int i = 0; i < word.length(); i++) {
            if (!t.letters.containsKey(word.charAt(i))) {
                t.letters.put(word.charAt(i), new TrieNodeV3());
            }
            t = t.letters.get(word.charAt(i));
        }
        t.word = word;
    }


    private String searchRootOfWord(String word){
        TrieNodeV3 t = this.dict;
        int i = 0;
        for(; i < word.length() ; i++){
            if(t.word != null) break;
            char c = word.charAt(i);
            if(t.letters.containsKey(c)){
                t = t.letters.get(c);
            }else{
                break;
            }
        }

        return t.word != null ? word.substring(0,i) : word;

    }

    public String replaceWords(List<String> dict, String sentence) {
        for(String word:dict){
            insertIntoDict(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder strBld = new StringBuilder();
        int index = 0;
        for(String word: words){
            if(index != 0) strBld.append(" ");
            String result = searchRootOfWord(word);
            strBld.append(result);
            index++;
        }
        return strBld.toString();
    }

    public static void main(String[] args) {

        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        ReplaceWords obj = new ReplaceWords();
        System.out.println(obj.replaceWords(dict, "the cattle was rattled by the battery"));

        List<String> dict1 = new ArrayList<>();
        dict1.add("a");
        dict1.add("aa");
        dict1.add("aaa");
        ReplaceWords obj1 = new ReplaceWords();
        System.out.println(obj1.replaceWords(dict1, "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));


    }

}
