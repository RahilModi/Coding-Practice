package com.programming.leetcode.Hard;

import java.util.*;

//https://leetcode.com/problems/palindrome-pairs/discuss/79195/O(n-*-k2)-java-solution-with-Trie-structure
public class PalindromePairs {

    //O(n^2)
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                StringBuilder sb = new StringBuilder(words[i]+words[j]);
                if(j!= i && (words[i].isEmpty() || words[j].isEmpty())){
                    if(sb.toString().equals(sb.reverse().toString())){
                        res.add(new ArrayList<>(Arrays.asList(new Integer[]{i,j})));
                    }
                }
                else if(j != i && words[i].charAt(0) == words[j].charAt(words[j].length()-1)){
                    String crt = sb.toString();
                    if(crt.equals(sb.reverse().toString())){
                        res.add(new ArrayList<>(Arrays.asList(new Integer[]{i,j})));
                    }
                }
            }
        }
        return res;
    }


    public List<List<Integer>> palindromePairsV1(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length < 2) return res;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length ; i++) map.put(words[i],i);
        int i = 0;
        for(String w : words){
            for(int j = 0; j <= w.length(); j++){
                String p1 = w.substring(0,j);
                String p2 = w.substring(j);
                if(isPalindrome(p1)){
                    String reverseP2 = new StringBuilder(p2).reverse().toString();
                    if(map.getOrDefault(reverseP2,i)!=i){
                        res.add(Arrays.asList(new Integer[]{map.get(reverseP2),i}));
                    }
                }
                if (isPalindrome(p2)){
                    String reverseP1 = new StringBuilder(p1).reverse().toString();
                    if(map.getOrDefault(reverseP1,i)!=i && p2.length()!=0){
                        res.add(Arrays.asList(new Integer[]{i,map.get(reverseP1)}));
                    }
                }
            }
            i++;
        }
        return res;
    }

    private boolean isPalindrome(String b){
        return b.equals(new StringBuilder(b).reverse().toString());
    }

    static class TrieNode {
        TrieNode[] letters = new TrieNode[26];
        List<Integer> wordIndex = new ArrayList<>();
        int startIndex = -1;
    }

    public void addWord(TrieNode root, String word, int pos){
        TrieNode p = root;
        for(int i = word.length()-1; i>=0; i--){
            int index = word.charAt(i)-'a';
            if(p.letters[index]==null){
                p.letters[index] = new TrieNode();
            }
            if(isPalindrome(word,0,i)){
                p.wordIndex.add(pos);
            }
            p=p.letters[index];
        }
        p.wordIndex.add(pos);
        p.startIndex=pos;
    }

    public void search(TrieNode root, String[] words, int i, List<List<Integer>>res){
        for (int j = 0; j < words[i].length(); j++) {
            if (root.startIndex >= 0 && root.startIndex != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.startIndex));
            }

            root = root.letters[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }

        for (int j : root.wordIndex) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }

    public List<List<Integer>> palindromePairsTrie(String[] words){
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            search(root, words, i, res);
        }

        return res;
    }

    public static void main(String[] args) {
        PalindromePairs obj = new PalindromePairs();
        obj.palindromePairsV1(new String[]{"abcd","dcba","lls","s","sssll"});
        obj.palindromePairsTrie(new String[]{"abcd","dcba","lls","s","sssll"});
    }



}
