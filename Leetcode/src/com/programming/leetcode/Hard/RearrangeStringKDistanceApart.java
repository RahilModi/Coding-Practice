package com.programming.leetcode.Hard;

import java.util.*;

public class RearrangeStringKDistanceApart {

    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->a.getValue() != b.getValue() ? b.getValue().compareTo(a.getValue()) : a.getKey().compareTo(b.getKey()));
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> temp = new LinkedList<>();

        while (!pq.isEmpty()){
            Map.Entry<Character, Integer> top = pq.poll();
            sb.append(top.getKey());
            top.setValue(top.getValue() - 1);
            temp.add(top);
            if(temp.size() >= k) {
                Map.Entry<Character,Integer> entry = temp.poll();
                if(entry.getValue() > 0) {
                    pq.add(entry);
                }
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        RearrangeStringKDistanceApart obj = new RearrangeStringKDistanceApart();
        System.out.println(obj.rearrangeString("abacabcd",2));
    }
}
