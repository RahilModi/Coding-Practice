package com.programming.leetcode.Medium;

import sun.jvm.hotspot.oops.CharField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {

    //Time Limit Exceeds....
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        for(String s : A){
            Map<Character, Integer> map = new HashMap<>();
            for(char c: s.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
            boolean bWordNotInSubset = false;
            for(String t: B){
                Map<Character, Integer> toTransfer = new HashMap<>();
                for(char c: t.toCharArray()) {
                    if(map.getOrDefault(c,0)==0){
                        bWordNotInSubset = true;
                    }else{
                        toTransfer.put(c,toTransfer.getOrDefault(c,0)+1);
                        map.put(c,map.get(c)-1);
                    }
                    if(bWordNotInSubset) break;
                }
                for(Character c: toTransfer.keySet())
                    map.put(c, map.get(c)+toTransfer.get(c));
                if(bWordNotInSubset)break;
            }
            if(!bWordNotInSubset) res.add(s);
        }
        return res;
    }

    public int[] count(String x){
        int count[] = new int[26];
        for(char c : x.toCharArray()) count[c-'a']++;
        return count;
    }

    public List<String> wordSubsetsV1(String[] A, String[] B) {
        int count[] = new int[26];
        for(String b : B){
            int[] bCount = count(b);
            for(int i = 0 ; i <26; i++){
                count[i] = Math.max(count[i], bCount[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for(String a : A){
            int [] aCount = count(a);
            boolean bNotPoss = false;
            for(int i =0; i < 26; i++){
                if(count[i] > aCount[i]){
                    bNotPoss = true;
                    break;
                }
            }
            if(!bNotPoss) res.add(a);
        }
        return res;
    }


    public static void main(String[] args) {
        WordSubsets obj = new WordSubsets();
        System.out.println(obj.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"e","o"}));
    }
}
