package com.programming.leetcode.Medium;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //return bfs_helper(wordList, endWord, beginWord);
        return bfs_helper_using_queue_size(wordList, endWord, beginWord);
    }

    //We use Map to count the path
    public int bfs_helper(List<String> wordDict, String endWord, String firstWord){
        Set<String> dictSet = new HashSet<>();
        dictSet.addAll(wordDict);
        if(!dictSet.contains(endWord)) return 0;
        int minPath = Integer.MAX_VALUE;
        Queue<String> wordPath = new LinkedList<>();
        wordPath.offer(firstWord);
        Map<String,Integer> wordsInPath = new HashMap<>();
        wordsInPath.put(firstWord, 1);
        while(!wordPath.isEmpty()){
            String crt_word = wordPath.poll();
            for(String word: dictSet){
                if(!wordsInPath.containsKey(word) && isDistanceBetweenTwoStringOne(crt_word, word))
                    if(word.equals(endWord)){
                        minPath = Math.min(wordsInPath.get(crt_word)+1,minPath);
                    }else {
                        wordPath.offer(word);
                        wordsInPath.put(word, wordsInPath.get(crt_word)+1);
                    }
                }
        }
        return minPath == Integer.MAX_VALUE ? 0 : minPath;
    }

    //In this I used approach to generate new words by changing only one letter at a time from crt_word
    public int bfs_helper_1(List<String> wordDict, String endWord, String firstWord){
        Set<String> dictSet = new HashSet<>();
        dictSet.addAll(wordDict);
        if(!dictSet.contains(endWord)) return 0;
        Queue<String> wordPath = new LinkedList<>();
        wordPath.offer(firstWord);
        Map<String,Integer> wordsInPath = new HashMap<>();
        wordsInPath.put(firstWord, 1);
        while(!wordPath.isEmpty()){
            String crt_word = wordPath.poll();
            for (int i = 0; i < crt_word.length(); i++) {
                char[] new_word = crt_word.toCharArray();
                for(char ch='a'; ch <= 'z'; ch++) {
                    new_word[i] = ch;
                    String crt_new_word = String.valueOf(new_word);
                    if(dictSet.contains(crt_new_word)) {
                        if (crt_new_word.equals(endWord)) {
                            return wordsInPath.get(crt_word)+1;
                        } else if(!wordsInPath.containsKey(crt_new_word)) {
                            wordPath.offer(crt_new_word);
                            wordsInPath.put(crt_new_word, wordsInPath.get(crt_word) + 1);
                        }
                    }
                }
            }
        }
        return 0;
    }

    //We can use Queue Size for the same...
    //Also use another approach to calculate new word..whose distance is 1 from the crt_word.
    //by changing one letter of the word at a time and check whether that word is present in the given dictionary
    //If present add them into queue
    public int bfs_helper_using_queue_size(List<String> wordDict, String endWord, String firstWord){
        Set<String> dictSet = new HashSet<>();
        dictSet.addAll(wordDict);
        if(!dictSet.contains(endWord)) return 0;
        int minPath = Integer.MAX_VALUE;
        Queue<String> wordPath = new LinkedList<>();
        wordPath.offer(firstWord);
        int res = 0;
        while(!wordPath.isEmpty()){
            for(int  k = wordPath.size(); k > 0 ; --k) {
                String crt_word = wordPath.poll();
                if (endWord.equals(crt_word)) {
                    minPath = Math.min(res + 1, minPath);
                }
                for (int i = 0; i < crt_word.length(); i++) {
                    char[] new_word = crt_word.toCharArray();
                    for(char ch='a'; ch <= 'z'; ch++) {
                        new_word[i] = ch;
                        String crt_new_word = String.valueOf(new_word);
                        if(dictSet.contains(crt_new_word)) {
                            wordPath.offer(crt_new_word);
                            dictSet.remove(crt_new_word);
                        }
                    }
                }
            }
            ++res;
        }
        return minPath == Integer.MAX_VALUE ? 0 : minPath;
    }

    private boolean isDistanceBetweenTwoStringOne(String s1, String s2){
        //assumed both have the same length other wise we have to take the min length as breaking condition and perform one more validation based on diff value after while
        int diff = 0, index = 0;
        while(diff < 2 && index < s1.length()){
            if(s1.charAt(index) != s2.charAt(index)){
                diff++;
            }
            index++;
        }

        return diff == 1;
    }

    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit","cog",new ArrayList<>(Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}))));
    }

}
