package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    TrieNodeV5 root;
    Map<String, Integer> countMap = new HashMap<>();

    class TrieNodeV5{
        Map<Character, TrieNodeV5> letters = new HashMap<>();
        int val = 0;
        boolean isWord = false;
    }
    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new TrieNodeV5();
    }

    public void insert(String key, int val) {
        TrieNodeV5 temp = this.root;
        int prevVal = 0;
        if(countMap.containsKey(key)){
            prevVal = countMap.get(key);
        }
        countMap.put(key,val);
        for(char c: key.toCharArray()){
            if(!temp.letters.containsKey(c)){
                temp.letters.put(c,new TrieNodeV5());
            }
            temp = temp.letters.get(c);
            temp.val = temp.val + val - prevVal;
        }
        temp.isWord = true;
    }

    public int sum(String prefix) {
        TrieNodeV5 temp = this.root;
        for(char c: prefix.toCharArray()){
            if(temp.letters.containsKey(c)){
                temp = temp.letters.get(c);
            }else{
                return 0;
            }
        }
        return temp.val;
    }

    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("apple",3);
        System.out.println(obj.sum("app"));
        obj.insert("app",2);
        System.out.println(obj.sum("ap"));

        obj.insert("aa",3);
        System.out.println(obj.sum("a"));
        obj.insert("aa",2);
        System.out.println(obj.sum("a"));
    }
}
