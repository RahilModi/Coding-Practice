package com.programming.leetcode.Medium;

public class gameOfLife {

    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)  return;
        int m = board.length, n = board[0].length;
        for(int i = 0 ;i < m; i++){
            for(int j = 0; j < n; j++){
                int neighbors = numOfLiveNeighbors(board, m,n, i, j);
                if(board[i][j] == 1 && neighbors >= 2 && neighbors <=3) board[i][j] = 3;
                else if(board[i][j] == 0 && neighbors == 3)board[i][j] = 2;

            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int numOfLiveNeighbors(int [][] B, int m, int n, int i, int j){
        int ans = 0;
        for(int k = Math.max(i-1,0); k <= Math.min(i+1, m-1); k++){
            for(int l = Math.max(j-1, 0); l <= Math.min(j+1, n-1);l++){
                ans += B[k][l]&1;
            }
        }
        return ans -= B[i][j]&1;
    }
}
