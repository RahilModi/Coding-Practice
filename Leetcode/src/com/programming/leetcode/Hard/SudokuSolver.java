package com.programming.leetcode.Hard;

import java.util.Arrays;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        boolean[][] horizontal = new boolean[9][9];
        boolean[][] vertical = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];


        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j]!='.'){
                    int crt_val = board[i][j]-'1';
                    int box_index = 3 * (i/3) + (j/3);
                    horizontal[i][crt_val] = vertical[j][crt_val] = boxes[box_index][crt_val] = true;
                }
            }
        }
        sudokuSolverUtil(board,horizontal,vertical,boxes,0,0);
    }


    public boolean sudokuSolverUtil(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] boxes, int row, int col){
        if(col == 9){
            row = row + 1;
            col = 0;
        }
        if(row == 9) return true;

        if(board[row][col] != '.') return sudokuSolverUtil(board,rows,cols,boxes,row,col+1);

        for(int val =1 ; val <= 9; val++){
            int boxIndex = 3 * (row/3) + col/3;
            if(rows[row][val-1] == false && cols[col][val-1] == false && boxes[boxIndex][val-1] == false){
                rows[row][val-1] = true;
                cols[col][val-1] = true;
                boxes[boxIndex][val-1] = true;
                board[row][col] = (char) (val+'0');
                //print(board);
                if(sudokuSolverUtil(board,rows,cols,boxes,row,col+1)){
                    return true;
                }
                board[row][col] = '.';
                rows[row][val-1] = false;
                cols[col][val-1] = false;
                boxes[boxIndex][val-1] = false;
               // print(board);
            }
        }
        return false;
    }

    void print(char[][] board){
        for(char[] line : board)
            System.out.println(Arrays.toString(line));
        System.out.println();
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
        SudokuSolver obj = new SudokuSolver();
        obj.solveSudoku(sudokuboard);
        obj.print(sudokuboard);
        System.out.println("solved...");
    }

}
