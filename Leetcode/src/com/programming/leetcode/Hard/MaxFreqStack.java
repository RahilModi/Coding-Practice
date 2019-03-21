package com.programming.leetcode.Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFreqStack {

    Map<Integer, Integer> freqCount;
    Map<Integer, Stack<Integer>> maxFreq;
    int maxFreqCount;
    public MaxFreqStack() {
        freqCount = new HashMap<>();
        maxFreq = new HashMap<>();
        maxFreqCount = 0;
    }

    public void push(int x) {
        freqCount.put(x, freqCount.getOrDefault(x, 0)+1);
        int freq = freqCount.get(x);
        if(maxFreqCount < freq){
            maxFreqCount = freq;
        }
        maxFreq.computeIfAbsent(freq, k -> new Stack<>()).push(x);
    }


    public int pop() {
        int val = maxFreq.get(maxFreqCount).pop();
        freqCount.put(val, maxFreqCount-1 );
        if(maxFreq.get(maxFreqCount).isEmpty()) maxFreqCount--;
        return val;
    }
}
