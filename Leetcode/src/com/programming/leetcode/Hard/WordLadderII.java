package com.programming.leetcode.Hard;

import com.programming.leetcode.Medium.ListNode;

import java.util.*;

public class WordLadderII {


    Set<String> dict = new HashSet<>();
    Map<String,List<String>> neighbors = new HashMap<>();
    Map<String, Integer> distance = new HashMap<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))return res;
        dict.addAll(wordList);
        bfs(beginWord,endWord);
        dfs(beginWord,endWord, new ArrayList<String>());
        return res;
    }

    private void bfs(String beginWord, String endWord){

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        distance.put(beginWord,0);
        boolean bFound = false;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            while (queueSize-- > 0) {
                String start = queue.poll();
                int crtDistance = distance.get(start);
                List<String> neighbors1 = getNeighbors(start);
                for (String str : neighbors1) {
                    neighbors.computeIfAbsent(start, k -> new ArrayList<>()).add(str);
                    if (!distance.containsKey(str)) {
                        distance.put(str, crtDistance+1);
                        if(str.equals(endWord)) bFound = true;
                        else queue.offer(str);
                    }
                }
                if(bFound) break;
            }
        }
    }

    private List<String> getNeighbors(String word){
        List<String> res = new ArrayList<>();
        char chs[] = word.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    private void dfs(String crt, String end, List<String> crtPath){
        crtPath.add(crt);
        if(end.equals(crt)){
            res.add(new ArrayList<>(crtPath));
        }
        else{
            if(neighbors.containsKey(crt)) {
                for (String neighbor : neighbors.get(crt)) {
                    if (distance.get(neighbor) == distance.get(crt) + 1) {
                        dfs(neighbor, end, crtPath);
                    }
                }
            }
        }
        crtPath.remove(crtPath.size()-1);
    }

    public static void main(String[] args) {
        WordLadderII obj = new WordLadderII();
        System.out.println(obj.findLadders("hit", "cog",Arrays.asList("hot","dot","dog","lot","log","cog")));
    }



}
