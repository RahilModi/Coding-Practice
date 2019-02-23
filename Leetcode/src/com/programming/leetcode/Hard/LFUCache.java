package com.programming.leetcode.Hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    Map<Integer, Integer> cache;
    Map<Integer, Integer> freq;
    Map<Integer, LinkedHashSet<Integer>> orderedFreq;
    int min = -1;
    int capacity;

    public LFUCache(int capacity) {
        cache= new HashMap<>();
        freq = new HashMap<>();
        orderedFreq = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!this.cache.containsKey(key)) return -1;
        int count=this.freq.get(key);
        this.freq.put(key,count+1);
        this.orderedFreq.get(count).remove(key);
        if(min == count && this.orderedFreq.get(min).isEmpty()) {
            min = count + 1;
        }
        this.orderedFreq.computeIfAbsent(count+1, k -> new LinkedHashSet<>()).add(key);
        return this.cache.get(key);
    }

    public void put(int key, int value) {
        if(this.capacity == 0) return;
        if(cache.containsKey(key)){
            this.cache.put(key,value);
            get(key);
            return;
        }else{
            if(this.capacity == this.cache.size()){
                int k = this.orderedFreq.get(min).iterator().next();
                this.orderedFreq.get(min).remove(k);
                this.freq.remove(k);
                this.cache.remove(k);
            }
            this.cache.put(key,value);
            min = 1;
            this.freq.put(key,1);
            this.orderedFreq.computeIfAbsent(min, k->new LinkedHashSet<>()).add(key);
        }
    }

    public static void main(String[] args) {
        LFUCache obj = new LFUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        obj.get(2);
    }

}
