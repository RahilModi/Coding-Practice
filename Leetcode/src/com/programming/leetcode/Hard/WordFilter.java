package com.programming.leetcode.Hard;

import java.util.*;

//Prefix Suffix Query Search
public class WordFilter {

    //https://leetcode.com/problems/prefix-and-suffix-search/discuss/110044/Three-ways-to-solve-this-problem-in-Java
    /*
    WordFilter: Time = O(NL^2)
    f: Time = O(1)
    Space = O(NL^2)
    Note: N is the size of input array and L is the max length of input strings.
     */
    Map<String, Integer> possibleQueries = new HashMap<>();
    public WordFilter(String[] words) {
        int index = 0;
        for (String w : words) {
            for (int i = 0; i <= w.length(); i++) {
                for (int j = 0; j <= w.length(); j++) {
                    String queryString = w.substring(0, i) + "#" + w.substring(w.length() - j);
                    System.out.println(queryString);
                    possibleQueries.put(queryString, index);
                }
            }
            index++;
        }
    }

    public int f(String prefix, String suffix) {
        return possibleQueries.getOrDefault(prefix+"#"+suffix,-1);
    }


    /*
    WordFilter: Time = O(NL)
    f: Time = O(N)
    Space = O(NL)
     */
    Map<String, List<Integer>> prefixMap = new HashMap<>();
    Map<String, List<Integer>> suffixMap = new HashMap<>();
    public void WordFilterV1(String[] words) {
        int index = 0;
        for (String w : words) {
            for (int i = 0; i <= w.length(); i++) {
                prefixMap.computeIfAbsent(w.substring(0,i), k->new ArrayList<>()).add(index);
            }
            for(int i = 0; i <= w.length(); i++){
                suffixMap.computeIfAbsent(w.substring(w.length()-i), k->new ArrayList<>()).add(index);
            }
            index++;
        }
    }

    public int f1(String prefix, String suffix) {
        if(prefixMap.containsKey(prefix) && suffixMap.containsKey(suffix)){
            List<Integer> wordPrefixIndexes = prefixMap.get(prefix);
            List<Integer> wordSuffixIndexes = suffixMap.get(suffix);
            int i = wordPrefixIndexes.size()-1, j = wordSuffixIndexes.size()-1;
            while (i >=0 && j >= 0){
                if(wordPrefixIndexes.get(i) > wordSuffixIndexes.get(j)) i--;
                else if(wordPrefixIndexes.get(i) < wordSuffixIndexes.get(j)) j--;
                else return wordPrefixIndexes.get(i);
            }
        }
        return -1;
    }


    /*
    WordFilter: Time = O(1)
    f: Time = O(NL)
    Space = O(1)
     */
    String[] input;
    public void WordFilterV2(String[] words) {
        input = words;
    }
    public int fV2(String prefix, String suffix) {
        for(int i = input.length-1; i >= 0; i--){
            if(input[i].startsWith(prefix) && input[i].endsWith(suffix)) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        WordFilter obj = new WordFilter(new String[]{"apple"});
        System.out.println(obj.f("a","e"));
    }
}
