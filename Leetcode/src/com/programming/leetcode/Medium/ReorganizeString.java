package com.programming.leetcode.Medium;

import java.util.*;
import java.util.stream.Collectors;

public class ReorganizeString {

    public String reorganizeString(String S) {
        Map<Character,Integer> charFrq = new HashMap<>();
        for(char c: S.toCharArray()){
            charFrq.put(c,charFrq.getOrDefault(c,0)+1);
        }

        List<Map.Entry<Character,Integer>> sortedEntries = new ArrayList<>(charFrq.entrySet());
        Collections.sort(sortedEntries, Map.Entry.<Character,Integer>comparingByValue().reversed());

        if(sortedEntries.get(0).getValue() > ((S.length()+1)/2)) return "";
        char[] res = new char[S.length()];
        int pos = 0,i =0;
        while (i < sortedEntries.size()){
            int j = 0;
            while(j < sortedEntries.get(i).getValue()){
                res[pos] = sortedEntries.get(i).getKey();
                pos += 2;
                if(pos >= res.length) pos =1;
                j++;
            }
            i++;
        }
        return String.valueOf(res);

    }
    static class MultiChar {
        int count;
        char letter;
        MultiChar(int ct, char ch) {
            count = ct;
            letter = ch;
        }
    }

    //using Max heap
    public String reorganizeStringUsingGreedy(String S) {
        int N = S.length();
        int[] count = new int[26];
        for (char c: S.toCharArray()) count[c-'a']++;
        PriorityQueue<MultiChar> pq = new PriorityQueue<MultiChar>((a, b) ->
                a.count == b.count ? a.letter - b.letter : b.count - a.count);

        for (int i = 0; i < 26; ++i) if (count[i] > 0) {
            if (count[i] > (N + 1) / 2) return "";
            pq.add(new MultiChar(count[i], (char) ('a' + i)));
        }

        StringBuilder ans = new StringBuilder();
        while (pq.size() >= 2) {
            MultiChar mc1 = pq.poll();
            MultiChar mc2 = pq.poll();
            ans.append(mc1.letter);
            ans.append(mc2.letter);
            if (--mc1.count > 0) pq.add(mc1);
            if (--mc2.count > 0) pq.add(mc2);
        }

        if (pq.size() > 0) ans.append(pq.poll().letter);
        return ans.toString();
    }


    public static void main(String[] args) {
        ReorganizeString obj = new ReorganizeString();
        System.out.println(obj.reorganizeString("aab"));
        System.out.println(obj.reorganizeString("aaba"));
        System.out.println(obj.reorganizeString("vvvlo"));
    }

}
