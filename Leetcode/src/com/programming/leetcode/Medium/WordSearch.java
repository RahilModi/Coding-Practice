package com.programming.leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length ; i++){
            for(int j = 0; j <board[i].length ; j++){
                if(backTrack(i,j,0,word,board, new HashSet<String>())){
                    return true;
                }
            }
        }
        return false;
    }

    //we can modify the current value in the dict to '#' to reduce extra space.
    private boolean backTrack(int row, int col, int crt_pos, String word, char[][] dict, Set<String> visited){
        if(row < 0 || row >= dict.length || col < 0 || col >= dict[row].length) return false;
        if(visited.contains(row+","+col)) return false;
        if(word.charAt(crt_pos) == dict[row][col]){
            visited.add(row+","+col);
            if(crt_pos == word.length()-1) return true;
            else if(backTrack(row+1,col,crt_pos+1,word,dict,visited)||backTrack(row,col+1,crt_pos+1,word,dict,visited)||backTrack(row-1,col,crt_pos+1,word,dict,visited)||backTrack(row,col-1,crt_pos+1,word,dict,visited
            )) {
                return true;
            }
            visited.remove(row+","+col);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB"));

        System.out.println(new WordSearch().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE"));

        System.out.println(new WordSearch().exist(new char[][]{{'a','b'},{'c','d'}},"bacd"));

        System.out.println(new WordSearch().exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}},
        "ABCESEEEFS"));
    }
}
