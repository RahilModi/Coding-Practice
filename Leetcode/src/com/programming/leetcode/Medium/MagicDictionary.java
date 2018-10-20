package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

class TrieNodeV4{

    Map<Character, TrieNodeV4> letters = new HashMap<>();
    char val;
    boolean isWord;

    TrieNodeV4(char val){
        this.val = val;
    }

}

public class MagicDictionary {
    TrieNodeV4 root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNodeV4(' ');
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        TrieNodeV4 t;
        for(String word: dict) {
            t = this.root;
            for (int i = 0; i < word.length(); i++) {
                if (!t.letters.containsKey(word.charAt(i))) {
                    t.letters.put(word.charAt(i), new TrieNodeV4(word.charAt(i)));
                }
                t = t.letters.get(word.charAt(i));
            }
            t.isWord = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        for(int i =0 ; i < arr.length; i++){
            for(char c = 'a'; c <= 'z' ; c++){
                if(arr[i] == c)continue;
                char org = arr[i];
                arr[i] = c;
                if(searchHelper(new StringBuilder().append(arr).toString(), this.root)){
                    return true;
                }
                arr[i] = org;
            }
        }
        return false;
    }

    private boolean searchHelper(String word, TrieNodeV4 node){
        TrieNodeV4 t = node;
        for(char c : word.toCharArray()){
            if(t.letters.containsKey(c)) t = t.letters.get(c);
            else return false;
        }
        return t.isWord;
    }

    public static void main(String[] args) {
        MagicDictionary dict = new MagicDictionary();
        dict.buildDict(new String[]{"hello", "hallo", "leetcode"});
        System.out.println(dict.search("hello"));
        System.out.println(dict.search("hhllo"));
        System.out.println(dict.search("hell"));
        int x = 2;
        x = ~2;
        System.out.println(x+1);
    }

}
