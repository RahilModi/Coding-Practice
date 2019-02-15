package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        for(String w : words) {
            boolean bFound = false;
            for (int i = 0; i < board.length && !bFound; i++){
                for (int j = 0; j < board[0].length; j++) {
                    if (w.charAt(0) == board[i][j] && backtrack(board, i, j, 0,w, new StringBuilder(), new boolean[board.length][board[0].length])) {
                        if(!res.contains(w))res.add(w);
                        bFound = true;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public boolean backtrack(char[][] board, int r, int c, int crtIndex, String target, StringBuilder crt, boolean[][] visited){
        if(target.length() == crt.length() && target.equals(crt.toString())){
            return true;
        }
        if(r < 0 || r >= board.length || c <0 || c >= board[0].length || board[r][c] == '#' /*visited[r][c]*/) return false;
        if(crt.length() >= target.length()) return false;
        if(target.charAt(crtIndex) == board[r][c]) {
            //visited[r][c] = true;
            crt.append(board[r][c]);
            board[r][c] = '#';
            boolean res = backtrack(board, r+1, c, crtIndex+1, target,crt, visited) ||backtrack(board, r-1, c, crtIndex+1, target,crt, visited) ||backtrack(board, r, c+1, crtIndex+1, target,crt, visited)||backtrack(board, r, c-1, crtIndex+1, target,crt, visited);
            crt.deleteCharAt(crt.length()-1);
//            visited[r][c] = false;
            board[r][c] = target.charAt(crtIndex);
            return res;
        }
        return false;
    }

    static class TrieNode {
        TrieNode[] letters = new TrieNode[26];
        String Word;
    }
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode crt = root;
            for(char c:w.toCharArray()) {
                int index = c -'a';
                if(crt.letters[index] == null) crt.letters[index] = new TrieNode();
                 crt = crt.letters[index];
            }
            crt.Word = w;
        }
        return root;
    }

    public List<String> findWordsV2(char[][] board, String[] words) {
        TrieNode trie = buildTrie(words);
        List<String> res = new ArrayList<>();
        backtrackV2(board,0,0,trie,res);
        return res;
    }

    public void backtrackV2(char[][]board, int r, int c, TrieNode trie, List<String>res){
        if(r < 0 || r >= board.length || c <0 || c >= board[0].length ) return;
        char crt = board[r][c];
        if(crt == '#' || trie.letters[crt-'a'] == null) return;
        trie = trie.letters[crt-'a'];
        if(trie.Word != null){
            res.add(trie.Word);
            trie.Word=null;
        }
        board[r][c]='#';
        backtrackV2(board,r+1,c,trie,res);
        backtrackV2(board,r,c+1,trie,res);
        backtrackV2(board,r-1,c,trie,res);
        backtrackV2(board,r,c-1,trie,res);
        board[r][c]=crt;
    }


    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        WordSearchII obj = new WordSearchII();
        System.out.println(obj.findWords(new char[][]{{'a','b','c'},{'a','e','d'},{'a','f','g'}},new String[]{"eaabcdgfa"}));
        System.out.println(obj.findWords(new char[][]{{'a'}},new String[]{"a"}));
        System.out.println(obj.findWords(board,words));
    }

}
