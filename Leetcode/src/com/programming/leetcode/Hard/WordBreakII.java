package com.programming.leetcode.Hard;

import java.util.*;

public class WordBreakII {

    //TimeLimit Exceeds problem seems DFS logic..
    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> dict  = new HashSet<>();
        dict.addAll(wordDict);
        if(wordDict.isEmpty()) return new ArrayList<>();
        int max_len = Integer.MIN_VALUE, min_len = Integer.MAX_VALUE;
        for(String str: dict){
            max_len = Math.max(max_len, str.length());
            min_len = Math.min(min_len, str.length());
        }
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[s.length()];
        Map<Integer,List<Integer>> graph = new HashMap<>();
        queue.offer(0);
        while (!queue.isEmpty()){
            int pos = queue.poll();
            if(!visited[pos]){
                visited[pos] = true;
                for(int i = pos + min_len -1 ;i <s.length() && i-pos < max_len ; i++){
                    String crt = s.substring(pos,i+1);
                    if(dict.contains(crt)){
                        graph.computeIfAbsent(pos, k->new ArrayList<>()).add(i);
                        if(i+1 < s.length()) {
                            queue.offer(i+1);
                        }
                    }
                }
            }
        }

        List<String> res = new ArrayList<>();
        if(!graph.containsKey(0))return res;
        for(int i : graph.get(0)){
            StringBuilder sb = new StringBuilder();
            dfs(0, i+1, s, sb, graph, max_len, res);
        }
        return res;
    }

    private void dfs(int prev, int pos, String input, StringBuilder sb, Map<Integer, List<Integer>> res, int maxLength, List<String> result){
        if(maxLength < pos-prev) return;
        sb.append(prev==0 && sb.length()==0 ? ""+input.substring(prev, pos) : " "+input.substring(prev, pos));
        if(pos+1 > input.length()) {
            result.add(sb.toString());
            return;
        }
        String temp = sb.toString();
        if(!res.containsKey(pos))return;
        for(int i : res.get(pos)){
            dfs(pos, i+1, input, sb, res, maxLength, result);
            sb = new StringBuilder(temp);
        }
    }


    //DFS....
    public List<String> wordBreakV1(String s, List<String> wordDict) {
        return dfs(s, new HashMap<>(), new HashSet<>(wordDict));
    }

    public List<String> dfs(String s, Map<String, List<String>> map, Set<String> dict){
        if(map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        if(s.length() == 0){
            res.add("");
            return res;
        }
        for(String w: dict){
            if(s.startsWith(w)){
                List<String> crtAns = dfs(s.substring(w.length()), map,dict);
                for(String str : crtAns){
                    res.add(w + (str.isEmpty() ? "" : " ")+str);
                }
                map.put(s, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WordBreakII obj = new WordBreakII();
        System.out.println(obj.wordBreak("ab",  Arrays.asList("a","b") ));

        System.out.println(obj.wordBreak("catsanddog",  Arrays.asList("cats", "dog", "sand", "and", "cat") ));
    }
}
