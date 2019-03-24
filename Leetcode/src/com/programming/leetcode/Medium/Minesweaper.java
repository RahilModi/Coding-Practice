package com.programming.leetcode.Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Minesweaper {

    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> queue= new ArrayDeque<>();
        queue.offer(click);
        while (!queue.isEmpty()){
            int crt[] = queue.poll();
            int r = crt[0], c = crt[1];
            if(board[crt[0]][crt[1]] == 'M') {
                board[r][c]='X';
                return board;
            }else{
                int count = 0;
                for(int i = -1; i < 2; i++){
                    for(int j = -1; j < 2; j++){
                        if(i == 0 && j == 0) continue;
                        if(isValidPos(board, r+i, c+j) && (board[r+i][c+j] == 'M' || board[r+i][c+j] == 'X')) count++;
                    }
                }

                if(count > 0){
                    board[r][c] = (char) (count + '0');
                }else{
                    board[r][c] = 'B';
                    for(int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) continue;
                            if(isValidPos(board, r+i, c+j) && board[r+i][c+j] == 'E') {
                                queue.offer(new int[]{r + i, c + j});
                                board[r + i][c + j] = 'B';
                            }
                        }
                    }
                }
            }
        }

        return board;

    }

    private boolean isValidPos(char[][] board, int newR, int newC){
        return newR >= 0 && newC >= 0 && newR < board.length && newC < board[0].length;
    }

    public static void main(String[] args) {
        Minesweaper obj = new Minesweaper();
        System.out.println(Arrays.toString(obj.updateBoard(new char[][]{{'E'}},new int[]{0,0})));
    }
}
