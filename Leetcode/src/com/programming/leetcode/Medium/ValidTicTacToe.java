package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidTicTacToe {
    public boolean validTicTacToe(String[] board) {
        if(board == null || board.length != 3) return false;
        int numXMoves =0 , numOMoves=0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < board.length; i++){
            if(board[i].length() != 3) return false;
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j)==' ')continue;
                if(board[i].charAt(j) == 'X') numXMoves++;
                else  numOMoves++;
                map.computeIfAbsent(board[i].charAt(j), k -> new ArrayList<>()).add(i*board[i].length()+j);
            }
        }
        if(numOMoves > numXMoves) return false;
        if(numXMoves - numOMoves > 1) return false;
        int crtXIndex=0, crtOIndex=0;
        int[][] tictactoeBoard = new int[3][3];
        int player1=1, player2=2, crtTurn = 0, prevWon = 0;
        for(int i = 0; i < (numOMoves + numXMoves); i++){
            if(crtTurn > 1) crtTurn = crtTurn%2;
            int pos = crtTurn == 0 ?  map.get('X').get(crtXIndex++) : map.get('O').get(crtOIndex++);
            if(tictactoeBoard[pos/3][pos%3] == 0) {
                tictactoeBoard[pos/3][pos%3] = crtTurn == 0 ? player1 : player2;
            }

            if(i >= 4){
                int res = move(tictactoeBoard, pos/3, pos%3, crtTurn == 0 ? player1 : player2);
                if((res == 1 && numXMoves - numOMoves == 0) || (res == 2 && numXMoves-numOMoves==1)) return false;
            }
            crtTurn++;
        }
        return true;
    }

    public int move(int[][] board, int row, int col, int player) {
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
        if(count1 == 3 || count2 == 3 || count3 == 3 || count4 == 3)
            return player == 1 ? 1 : 2;
        return 0;
    }


    //https://leetcode.com/problems/valid-tic-tac-toe-state/discuss/117580/Straightforward-Java-solution-with-explaination
    public boolean validTicTacToeV1(String[] board) {
        int turns = 0;
        boolean xwin = false;
        boolean owin = false;
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int antidiag = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    turns++; rows[i]++; cols[j]++;
                    if (i == j) diag++;
                    if (i + j == 2) antidiag++;
                } else if (board[i].charAt(j) == 'O') {
                    turns--; rows[i]--; cols[j]--;
                    if (i == j) diag--;
                    if (i + j == 2) antidiag--;
                }
            }
        }

        xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
                cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
                diag == 3 || antidiag == 3;
        owin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
                cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
                diag == -3 || antidiag == -3;

        if (xwin && turns == 0 || owin && turns == 1) {
            return false;
        }
        return (turns == 0 || turns == 1) && (!xwin || !owin);
    }

    public boolean validTicTacToeV2(String[] board) {
        if (board.length == 0) {
            return false;
        }

        // turns = 0 represents 'X' will move, otherwise, 'O' will move
        int turns = 0;

        // check whether 'X' wins or 'O' wins, or no players win
        boolean xWin = isGameOver(board, 'X');
        boolean oWin = isGameOver(board, 'O');

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'X') {
                    turns++;
                }
                else if (board[i].charAt(j) == 'O') {
                    turns--;
                }
            }
        }

        /**
         * Four conditions will be the invalid tic tac toe board:
         * 1. there are more 'O' than 'X'
         * 2. the board has 2 more 'X' than 'O'
         * 3. number of 'X' is equal to number of 'O', but 'X' wins, it is impossible because if 'X' wins, the game is
         * over, 'O' cannot play again, then number of 'O' MUST less than 'X'
         * 4. number of 'X' is more than number of 'O', but 'O' wins, it is impossible because if 'O' wins, the game is
         * over, 'X' cannot play again, then number of 'X' CANNOT greater than 'O'
         * */
        if (turns < 0 || turns > 1 || turns == 0 && xWin || turns == 1 && oWin) {
            return false;
        }
        return true;
    }

    public boolean isGameOver(String[] board, char player) {
        // check horizontal
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                return true;
            }
        }

        // check vertical
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == player && board[0].charAt(j) == board[1].charAt(j) && board[1].charAt(j) == board[2].charAt(j)) {
                return true;
            }
        }

        // check diagonal
        if (board[1].charAt(1) == player && (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)
                || board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0))) {
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        String[] tictactoe = {"O  ","   ","   "};
        ValidTicTacToe obj = new ValidTicTacToe();
        System.out.println(obj.validTicTacToe(new String[]{"XXX", "OOX", "OOX"}));
        System.out.println(obj.validTicTacToe(tictactoe));
        System.out.println(obj.validTicTacToe(new String[]{"XOX", " X ", "   "}));
        System.out.println(obj.validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
        System.out.println(obj.validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
    }

}
