package com.programming.leetcode.Medium;

import java.util.*;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<Integer,List<String>> diffGroup = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(String s : strings){
            int key = getKey(s);
            List<String>l = diffGroup.getOrDefault(key, new ArrayList<>());
            l.add(s);
            diffGroup.put(key,l);
        }

        for(Map.Entry<Integer, List<String>> entry : diffGroup.entrySet()){
            Collections.sort(entry.getValue());
            res.add(entry.getValue());
        }
        return res;
    }

    int getKey(String s){
        int key = 0;
        for(int i = 1; i < s.length(); i++){
            int diff = s.charAt(i) - s.charAt(i-1);
            if(diff < 0) diff += 26;
            key += diff;
        }
        return key;
    }

    public static void main(String[] args) {
        GroupShiftedStrings obj = new GroupShiftedStrings();
        System.out.println(obj.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z","ab","bc"}));
    }
}
