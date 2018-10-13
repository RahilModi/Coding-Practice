package com.programming.leetcode.Medium;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();
        for(String s : words) wordCount.put(s, wordCount.getOrDefault(s, 0 ) +1);
        PriorityQueue<Map.Entry<String,Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue()==a.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );
        maxHeap.addAll(wordCount.entrySet());
        List<String> res = new ArrayList<>();
        while(res.size() < k){
            res.add(maxHeap.poll().getKey());
        }

        return res;
    }


    public List<String> topKFrequentUsingTrieAndBucketSort(String[] words, int k) {
        // calculate frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for(String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        // build the buckets
        TrieNode[] count = new TrieNode[words.length + 1];
        for(String word : freqMap.keySet()) {
            int freq = freqMap.get(word);
            if(count[freq] == null) {
                count[freq] = new TrieNode();
            }
            addWord(count[freq], word);
        }
        // get k frequent words
        List<String> list = new LinkedList<>();
        for(int f = count.length - 1; f >= 1 && list.size() < k; f--) {
            if(count[f] == null) continue;
            getWords(count[f], list, k);
        }
        return list;
    }

    private void getWords(TrieNode node, List<String> list, int k) {
        if(node == null) return;
        if(node.word != null) {
            list.add(node.word);
        }
        if(list.size() == k) return;
        for(int i = 0; i < 26; i++) {
            if(node.next[i] != null) {
                getWords(node.next[i], list, k);
            }
        }
    }

    private void addWord(TrieNode root, String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new TrieNode();
            }
            curr = curr.next[c - 'a'];
        }
        curr.word = word;
        return;
    }

    class TrieNode {
        TrieNode[] next;
        String word;
        TrieNode() {
            this.next = new TrieNode[26];
            this.word = null;
        }
    }


    public List<String> topKFrequentUsingHashMap(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for(String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, new Comparator<String>(){
            public int compare(String a, String b) {
                if(count.get(a) == count.get(b)) {
                    return a.compareTo(b);
                }
                return count.get(b) - count.get(a);
            }
        });

        return candidates.subList(0, k);
    }

    public static void main(String[] args) {
        List<String> result = new TopKFrequentWords().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 3);
        for(String str: result) System.out.println(str);

        List<String> result1 = new TopKFrequentWords().topKFrequentUsingTrieAndBucketSort(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        for(String str: result1) System.out.println(str);
    }
}
