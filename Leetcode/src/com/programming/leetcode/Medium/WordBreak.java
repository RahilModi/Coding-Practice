package com.programming.leetcode.Medium;

import java.util.*;

public class WordBreak {

    Set<String> dict = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        return backtrack(s, 0);
    }

    public boolean backtrack(String s, int pos){
        if(pos == s.length()) return true;
        for(int i = pos; i <= s.length(); i++){
            if(dict.contains(s.substring(pos,i))){
                if(backtrack(s, i)){
                    return true;
                }
            }
        }
        return false;
    }

    //BFS O(n^2) time complexity...
    //With min_len & max length performance improvement from 35% to 95 % faster

    public boolean wordBreakV1(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>();
        dictionary.addAll(wordDict);
        int max_len = 0, min_len = s.length();
        for(String str: dictionary) {
            max_len = Math.max(max_len, str.length()); //very good optimization...we should not go further if difference is more than max length of the char.
            min_len = Math.min(min_len, str.length());
        }
        Queue<Integer> bfsQueue = new ArrayDeque<>();
        boolean[] visited = new boolean[s.length()];
        bfsQueue.offer(0);
        while (!bfsQueue.isEmpty()){
            int start = bfsQueue.poll();
            if(!visited[start]){
                visited[start] = true;
                for(int i = start+min_len-1; i < s.length() && i-start < max_len; i++){
                    String crt_word = s.substring(start,i+1);
                    if(dictionary.contains(crt_word)){
                        bfsQueue.offer(i+1);
                        if(i+1 == s.length()) return true;
                    }
                }
            }
        }
        return false;
    }


    //DP...

    public boolean wordBreakDP(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        int min_len = s.length();
        for(String str: dict) {//very good optimization...we should not go further if difference is more than max length of the char.
            min_len = Math.min(min_len, str.length());
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = min_len; i <=s.length(); i++){
            for(int j = 0; j < i; j++){
                if(i-j >= min_len && dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        System.out.println(obj.wordBreakDP("leetcode", new ArrayList<>(Arrays.asList("leet","code"))));
        System.out.println(obj.wordBreakV1("leetcode", new ArrayList<>(Arrays.asList("leet","code"))));
    }



}
