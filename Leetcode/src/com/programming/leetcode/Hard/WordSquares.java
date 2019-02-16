package com.programming.leetcode.Hard;

import java.util.*;

public class WordSquares {

    Map<String, Set<String>> prefixes = new HashMap<>();

    public List<List<String>> wordSquares(String[] words) {
        for(String w : words){
            for(int i = 1; i <= w.length(); i++){
                prefixes.computeIfAbsent(w.substring(0,i), k ->new HashSet<>()).add(w);
            }
        }
        List<List<String>> res = new ArrayList<>();
        int size = words[0].length();
        for(String  w: words) {
            List<String> crt = new ArrayList<>();
            crt.add(words[0]);
            backtrack(crt, size, 1, res);
        }
        return res;
    }

    public void backtrack(List<String> crt, int size, int pos, List<List<String>> res){
        if(pos == size) {
            res.add(new ArrayList<>(crt));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(String can : crt){
            sb.append(can.charAt(pos));
        }
        if(!prefixes.containsKey(sb.toString())){
            return;
        }
        for(String next: prefixes.get(sb.toString())){
            crt.add(next);
            backtrack(crt, size, pos+1, res);
            crt.remove(crt.size()-1);
        }
    }

    public static void main(String[] args) {
        WordSquares obj =  new WordSquares();
        obj.wordSquares(new String[]{"ball","area","lead","lady"});
    }

}
