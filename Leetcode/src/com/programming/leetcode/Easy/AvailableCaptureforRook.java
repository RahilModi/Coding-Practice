package com.programming.leetcode.Easy;

public class AvailableCaptureforRook {
    public int numRookCaptures(char[][] board) {
        int row = -1, col = -1;
        for(int i = 0; i < board.length ; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'R'){
                    row = i;
                    col = j;
                }
            }
        }

        if(row == -1 && col == -1)return 0;
        int c = col, count = 0;
        boolean samePiece = false;
        while(c > 0 && !samePiece ){
            c -=1;
            if(board[row][c] != '.') {
                if (Character.isUpperCase(board[row][c])) {
                    samePiece = true;
                } else if (Character.isLowerCase(board[row][c])) {
                    count++;
                    break;
                }
            }
        }
        c = col;
        samePiece = false;
        while (c < board[row].length-1 && !samePiece){
            c += 1;
            if(board[row][c] != '.') {
                if (Character.isUpperCase(board[row][c])) {
                    samePiece = true;
                } else if (Character.isLowerCase(board[row][c])) {
                    count++;
                    break;
                }
            }
        }
        int r = row;
        samePiece = false;
        while(r > 0 && !samePiece ){
            r -=1;
            if(board[r][col] != '.') {
                if (Character.isUpperCase(board[r][col])) {
                    samePiece = true;
                } else if (Character.isLowerCase(board[r][col])) {
                    count++;
                    break;
                }
            }
        }
        r = row;
        samePiece = false;
        while (r < board.length-1 && !samePiece){
            r += 1;
            if(board[r][col] != '.') {
                if (Character.isUpperCase(board[r][col])) {
                    samePiece = true;
                } else if (Character.isLowerCase(board[r][col])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
