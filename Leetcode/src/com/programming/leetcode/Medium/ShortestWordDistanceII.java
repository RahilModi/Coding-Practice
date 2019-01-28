package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {

    Map<String, List<Integer>> wordIndexMapping = new HashMap<>();

    public void WordDistance(String[] words) {
        wordIndexMapping.clear();
        int index = 0;
        for(String word : words){
            List<Integer> list = wordIndexMapping.getOrDefault(word, new ArrayList<Integer>());
            list.add(index++);
            wordIndexMapping.put(word,list);
        }
    }

    public int shortest(String word1, String word2) {
        int min_dist = Integer.MAX_VALUE;
        List<Integer> word1Indexes = wordIndexMapping.get(word1);
        List<Integer> word2Indexes = wordIndexMapping.get(word2);

        for(int i = 0; i < word1Indexes.size(); i++){
            int p1 = word1Indexes.get(i);
            for(int j = 0; j < word2Indexes.size(); j++){
                int p2 = word2Indexes.get(j);
                min_dist = Math.min(min_dist, Math.abs(p1-p2));
            }
        }
        return min_dist;
    }

    public int shortestV2(String word1, String word2) {
        int min_dist = Integer.MAX_VALUE;
        List<Integer> word1Indexes = wordIndexMapping.get(word1);
        List<Integer> word2Indexes = wordIndexMapping.get(word2);

        int p1, p2, index1, index2;
        p1 = p2 = -1;
        index1 = index2 = 0;
        while( index1 < word1Indexes.size() && index2 < word2Indexes.size() ){
            p1 = word1Indexes.get(index1);
            p2 = word2Indexes.get(index2);

            min_dist = Math.min(min_dist, Math.abs(p1-p2));

            if(p1 < p2) index1++;
            else index2++;
        }

        while(index1 < word1Indexes.size()) {
            p1 = word1Indexes.get(index1++);
            min_dist = Math.min(min_dist, Math.abs(p1-p2));
        }

        while(index2 < word2Indexes.size()) {
            p2 = word2Indexes.get(index2++);
            min_dist = Math.min(min_dist, Math.abs(p1-p2));
        }

        return min_dist;
    }

    public static void main(String[] args) {
        ShortestWordDistanceII obj = new ShortestWordDistanceII();
        obj.WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        System.out.println(obj.shortest("practice","coding"));
        System.out.println(obj.shortest("practice","makes"));
        System.out.println(obj.shortestV2("makes","coding"));
        System.out.println(obj.shortestV2("practice","perfect"));
    }
}
