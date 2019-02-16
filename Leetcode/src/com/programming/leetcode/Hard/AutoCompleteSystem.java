package com.programming.leetcode.Hard;

import java.util.*;

public class AutoCompleteSystem {

    class TrieNode{
        Map<Character, TrieNode> childs = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();
        boolean isWord;
    }

    class Pair{
        String s;
        int count;
        public Pair(String s,int c) {
            this.s = s;
            this.count = c;
        }
    }
    TrieNode root;
    String prefix;

    public AutoCompleteSystem(String [] Sentences, int[] freq) {
        root = new TrieNode();
        prefix ="";
        int index = 0;
        for(String st : Sentences){
            add(st,freq[index++]);
        }
    }

    public void add(String sentence, int times) {
        TrieNode p = root;
        for (char c : sentence.toCharArray()) {
            p.childs.computeIfAbsent(c, k -> new TrieNode());
            p = p.childs.get(c);
            p.counts.put(sentence, p.counts.getOrDefault(sentence, 0) + times);
        }
        p.isWord = true;
    }

    public List<String> input(char c){
        if(c == '#'){
            add(prefix,1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix += c;
        TrieNode p = root;
        for(char letter : prefix.toCharArray()){
            p.childs.computeIfAbsent(letter, k->new TrieNode());
            p = p.childs.get(letter);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.count==b.count ? a.s.compareTo(b.s) : b.count-a.count);
        for(String sentence : p.counts.keySet()){
            pq.add(new Pair(sentence, p.counts.get(sentence)));
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i < 3 && !pq.isEmpty() ; i++){
            res.add(pq.poll().s);
        }
        return res;
    }

    public static void main(String[] args) {
        AutoCompleteSystem obj = new AutoCompleteSystem(new String[]{"i love you","i love leetcode","ironman","island"}, new int[]{5,2,2,3});
        obj.input('i');
    }
}
