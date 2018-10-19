package com.programming.leetcode.Medium;

class TrieNodeV2{
    TrieNodeV2[] letters = new TrieNodeV2[26];
    String word = null;
}

class WordDictionary {

    TrieNodeV2 root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNodeV2();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNodeV2 t = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (t.letters[word.charAt(i) - 'a'] == null) {
                t.letters[word.charAt(i) - 'a'] = new TrieNodeV2();
            }
            t = t.letters[word.charAt(i) - 'a'];
        }
        t.word = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {

        return searchHelper(word, 0, this.root);

    }

    public boolean searchHelper(String word, int index, TrieNodeV2 node){
        if(index == word.length()) return node.word != null;
        TrieNodeV2 temp = node;
        char c = word.charAt(index);
        if(c != '.') return temp.letters[c-'a'] != null && searchHelper(word, index+1, temp.letters[c - 'a']);
        else{
            for(int j = 0; j <temp.letters.length; j++){
                if(temp.letters[j] != null && searchHelper(word, index+1, temp.letters[j])){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        dict.addWord("a");
        dict.addWord("ab");
        System.out.println(dict.search("pad"));
        System.out.println(dict.search("bad"));
        System.out.println(dict.search(".ad"));
        System.out.println(dict.search("..."));
        System.out.println(dict.search("a."));
    }
}
