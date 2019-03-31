package com.programming.leetcode.Medium;

import java.util.*;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> diffGroup = new HashMap<>();

        for(String s : strings){
            diffGroup.computeIfAbsent(getKey(s), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(diffGroup.values());
    }

    String getKey(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++){
            int diff = s.charAt(i) - s.charAt(i-1);
            sb.append(diff < 0 ? diff + 26 : diff);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GroupShiftedStrings obj = new GroupShiftedStrings();
        System.out.println(obj.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z","ab","bc"}));
    }
}
