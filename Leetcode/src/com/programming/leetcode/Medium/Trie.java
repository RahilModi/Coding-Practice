package com.programming.leetcode.Medium;

class TrieNode {
    char val;
    TrieNode[] letters = new TrieNode[26];
    boolean isWord;
    public TrieNode(char val){
        this.val = val;
        isWord = false;
    }
}

public class Trie{
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = this.root;
        for (int i = 0; i < word.length(); i++) {
            char crt_char = word.charAt(i);
            if (temp.letters[crt_char - 'a'] == null) {
                temp.letters[crt_char - 'a'] = new TrieNode(crt_char);
            }
            temp = temp.letters[crt_char-'a'];
        }
        temp.isWord = true;
        return;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = this.root;
        boolean bFound = false;
        int i = 0;
        while(temp != null && i < word.length() ){
            char t = word.charAt(i++);
            temp = temp.letters[t-'a'];
            if(temp != null && temp.isWord && i == word.length()) bFound = true;
        }
        return bFound;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = this.root;
        int i = 0;
        while(temp != null && i < prefix.length() ){
            char c = prefix.charAt(i++);
            temp = temp.letters[c-'a'];
        }
        return temp != null && i == prefix.length() ? true : false;
    }

    public static void main(String[] args) {
        Trie trieDS = new Trie();
        trieDS.insert("rahil");
        System.out.println(trieDS.search("parth"));
        System.out.println(trieDS.startsWith("b"));
    }
}
