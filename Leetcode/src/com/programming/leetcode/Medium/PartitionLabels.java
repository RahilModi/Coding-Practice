package com.programming.leetcode.Medium;

import java.util.*;
import java.util.stream.Collectors;

public class PartitionLabels {


    //Efficient solution...
    public List<Integer> partitionLabelsV1(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        int j = 0, anchor = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return result;
    }

    Map<Character, List<Integer>> charRange = new HashMap<>();
    public List<Integer> partitionLabels(String S) {
        int i = 0;
        for(char c : S.toCharArray()){
            List<Integer> list = charRange.getOrDefault(c, new ArrayList<>());
            if(list.isEmpty()) {
                list.add(i);
                list.add(i);
            }else {
                list.set(1, i);
            }
            charRange.put(c,list);
            i++;
        }
        List<List<Integer>> ranges = charRange.values().stream().collect(Collectors.toList());

        Collections.sort(ranges, (l1,l2)->l1.get(0)-l2.get(0));

        List<Integer> res = new ArrayList<>();
        for(int j = 0; j < ranges.size(); j++){
            List<Integer> crt_range = ranges.get(j);
            while(j+1 < ranges.size() &&  ranges.get(j+1).get(0) < crt_range.get(1)){
                crt_range.set(0, Math.min(crt_range.get(0), ranges.get(j+1).get(0)));
                crt_range.set(1, Math.max(crt_range.get(1), ranges.get(j+1).get(1)));
                j++;
            }
            res.add(crt_range.get(1)-crt_range.get(0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels obj = new PartitionLabels();
        List<Integer> res = obj.partitionLabels("ababcbacadefegdehijhklij");
        for(int i : res) System.out.println(i);
    }
}
