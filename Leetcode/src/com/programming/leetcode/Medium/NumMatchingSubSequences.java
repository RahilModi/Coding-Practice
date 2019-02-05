package com.programming.leetcode.Medium;

import java.util.*;

public class NumMatchingSubSequences {

    int num_matched = 0;
    Map<String,Integer> dict = new HashMap<>();
    //Time Limit Exceeds...
    public int numMatchingSubseq(String S, String[] words) {
        for(String word: words) dict.put(word, dict.getOrDefault(word,0)+1);
        helper(S, 0, "");
        return num_matched;
    }

    public void helper(String s, int pos, String subsequence){
        if(!subsequence.isEmpty() && dict.containsKey(subsequence)){
            num_matched += dict.get(subsequence);
            dict.remove(subsequence);
        }
        for(int i = pos; i < s.length(); i++){
            helper(s, i+1, subsequence+s.charAt(i));
        }
    }


    //https://leetcode.com/problems/number-of-matching-subsequences/discuss/117598/Java-solution-using-HashMap-and-Queue
    public int numMatchingSubseqV1(String S, String[] words) {
        List<String>[]map = new List[26];
        for (char c = 'a'; c <= 'z'; c++){
            map[c-'a'] = new ArrayList<>();
        }
        for (String word : words) {
            map[word.charAt(0)-'a'].add(word);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            List<String> queue = map[c-'a'];
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.remove(0);
                if (word.length() == 1) {
                    count++;
                } else {
                    map[word.charAt(1)-'a'].add(word.substring(1));
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        NumMatchingSubSequences obj = new NumMatchingSubSequences();
        //System.out.println(obj.numMatchingSubseq("qlhxagxdqh", new String[]{"qlhxagxdq","qlhxagxdq","lhyiftwtut","yfzwraahab"}));
        System.out.println(obj.numMatchingSubseqV1("dsahjpjauf", new String[]{"ahjpjau","ja","ja","ahbwzgqnuk","tnmlanowax"}));
    }

}
