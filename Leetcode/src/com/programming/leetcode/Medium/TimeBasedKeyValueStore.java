package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

    Map<String, TreeMap<Integer, String>> keyValStore;
    /** Initialize your data structure here. */
    public TimeBasedKeyValueStore() {
        keyValStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keyValStore.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(keyValStore.containsKey(key)){
            Integer fKey = keyValStore.get(key).floorKey(timestamp);
            return fKey == null ? "" : keyValStore.get(key).get(fKey);
        }else return "";
    }
}
