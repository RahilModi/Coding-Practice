package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.List;

public class ConcatenateWords {

    static class Trie{
        boolean isWord;
        Trie[] next = new Trie[26];
    }
    private void  addWord(Trie node, String w){
        Trie crt = node;
        for(char c: w.toCharArray()){
            int id = c-'a';
            if(crt.next[id]==null){
                crt.next[id]=new Trie();
            }
            crt = crt.next[id];
        }
        crt.isWord = true;
    }

    private boolean testWord(Trie node, String w, int i, int count){
        Trie crt = node;
        for(int j = i; j < w.length(); j++) {
            int crtId = w.charAt(j) - 'a';
            if (crt.next[crtId] == null) return false;
            if (crt.next[crtId].isWord) {
                if (j == w.length() - 1) return count>=1;
                if (testWord(node, w, j + 1, count + 1))
                    return true;
            }
            crt=crt.next[crtId];
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words){
        List<String> res = new ArrayList<>();
        if(words ==null|| words.length == 0) return res;
        Trie root = new Trie();
        for(String w: words){
            if(w.isEmpty()) continue;
            addWord(root, w);
        }

        for(String w: words){
            if(w.isEmpty()) continue;
            if(testWord(root, w, 0,0)) res.add(w);
        }
        return res;
    }


    public static void main(String[] args) {
        ConcatenateWords obj = new ConcatenateWords();
        System.out.println(obj.findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
    }

}
