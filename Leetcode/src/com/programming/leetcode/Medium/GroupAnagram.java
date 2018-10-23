package com.programming.leetcode.Medium;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {

    Map<String, Map<Character, Integer>> strCharFreqMap = new HashMap<>();

    private void fillMap(String temp){
        Map<Character,Integer> charFreq = new HashMap<>();
        for(char c : temp.toCharArray()){
            charFreq.put(c, charFreq.getOrDefault(c, 0)+ 1);
        }
        strCharFreqMap.put(temp,charFreq);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        for(String word : strs){
            if(result.size() == 0){
                List<String> list = new ArrayList<>();
                list.add(word);
                fillMap(word);
                result.add(list);
            }else{
                boolean isFound = false;
                for(List<String> group : result){
                    if(group.size() > 0 && group.get(0).length() == word.length() && isAnagram(word, group.get(0), strCharFreqMap.get(group.get(0)))){
                        isFound = true;
                        group.add(word);
                        break;
                    }
                }
                if(!isFound){
                    List<String> list = new ArrayList<>();
                    list.add(word);
                    fillMap(word);
                    result.add(list);
                }
            }
        }

        return result;
    }

    private boolean isAnagram(String a, String b, Map<Character, Integer> _charFrq){
        Map<Character, Integer> charFreq = new HashMap<>();
        charFreq.putAll(_charFrq);
        //for(Character c : b.toCharArray()) charFreq.put(c, charFreq.getOrDefault(c,0)+1);
        for(Character c : a.toCharArray()) {
            if(charFreq.containsKey(c)){
                if(charFreq.get(c) == 1) {
                    charFreq.remove(c);
                }else{
                    charFreq.put(c,charFreq.get(c) -1);
                }
            }else{
                return false;
            }
        }
        return charFreq.isEmpty();
    }

    public static void main(String[] args) {
        GroupAnagram obj = new GroupAnagram();
        List<List<String>> res = obj.groupAnagramsV3(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for(List<String> group : res){
            for(String word : group){
                System.out.print(word + ", ");
            }
            System.out.println();
        }
    }

    public List<List<String>> groupAnagramsV2(String[] strs) {
        Map<String, List<String>> grouped = new HashMap<>();
        for(String word: strs){
            char[] temp = word.toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            if(!grouped.containsKey(key)){
                grouped.put(key, new ArrayList<>());
            }
            grouped.get(key).add(word);
        }
        return new ArrayList<>(grouped.values());
    }

    public List<List<String>> groupAnagramsV3(String[] strs) {
        Map<String, List<String>> grouped = new HashMap<>();
        int[] chars = new int[26];
        for(String word: strs){
            Arrays.fill(chars, 0);
            for(char c : word.toCharArray()){
                chars[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i : chars){
                sb.append('#');
                sb.append(i);
            }
            String key = sb.toString();
            if(!grouped.containsKey(key)){
                grouped.put(key, new ArrayList<>());
            }
            grouped.get(key).add(word);
        }
        return new ArrayList<>(grouped.values());
    }




}
