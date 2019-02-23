package com.programming.leetcode.Medium;

public class TicTacToe {

    int player1Moves, player2Moves, minMovesToWin;
    int[][] board;    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        player1Moves = 0;
        player2Moves = 0;
        minMovesToWin = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(board[row][col] == 0){
            board[row][col] = player;
        }
        if(player == 1) player1Moves++;
        else player2Moves++;
        if(player1Moves >= minMovesToWin || player2Moves >= minMovesToWin){
            int n = board.length-1;
            int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
            for(int i = 0; i < board.length; i++){
                if(board[i][col] == player){
                    count1++;
                }
                if(board[row][i] == player){
                    count2++;
                }
                if(board[n-i][i] == player){
                    count3++;
                }
                if(board[i][i] == player) {
                    count4++;
                }
            }
            int board = n+1;
            if(count1 == board || count2 == board || count3 == board || count4 == board)
                return player == 1 ? 1 : 2;
        }
        return 0;
    }


}
