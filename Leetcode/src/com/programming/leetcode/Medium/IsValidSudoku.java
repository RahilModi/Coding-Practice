package com.programming.leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] horizontal = new boolean[9][9];
        boolean[][] vertical = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];


        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j]!='.'){
                    int crt_val = board[i][j]-'1';
                    int box_index = 3 * (i/3) + (j/3);
                    if(horizontal[i][crt_val] || vertical[j][crt_val] || boxes[box_index][crt_val]) return false;
                    else{
                        horizontal[i][crt_val] = vertical[j][crt_val] = boxes[box_index][crt_val] = true;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuUsingHashSet(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j]!='.'){
                    int crt_val = board[i][j]-'1';
                    int box_index = 3 * (i/3) + (j/3);
                    if(!seen.add(crt_val+" in row "+i)
                            || !seen.add(crt_val+" in column "+j)
                            || !seen.add(crt_val + " in box "+ box_index)) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

          char[][] sudokuboard = new char[][]{
                  {'5','3','.','.','7','.','.','.','.'},
                  {'6','.','.','1','9','5','.','.','.'},
                  {'.','9','8','.','.','.','.','6','.'},
                  {'8','.','.','.','6','.','.','.','3'},
                  {'4','.','.','8','.','3','.','.','1'},
                  {'7','.','.','.','2','.','.','.','6'},
                  {'.','6','.','.','.','.','2','8','.'},
                  {'.','.','.','4','1','9','.','.','5'},
                  {'.','.','.','.','8','.','.','7','9'}
          };
          IsValidSudoku obj = new IsValidSudoku();
        System.out.println(obj.isValidSudoku(sudokuboard));
    }
}
