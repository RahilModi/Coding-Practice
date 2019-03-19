package com.programming.leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadders {

    public int snakesAndLadders(int[][] board) {

        int n = board.length, index = 0;
        int[] moves = new int[n*n];
        int i = n-1, j = 0, inc = 1;
        while (index < n*n){
            moves[index++] = board[i][j];
            if(inc == 1 && j == n-1){
                inc = -1;
                i--;
            }else if(inc == -1 && j == 0){
                i--;
                inc = 1;
            }else{
                j+=inc;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[n*n];
        int start = moves[0] > -1 ? moves[0] -1 : 0;
        queue.offer(start);
        seen[start] = true;
        int step = 0;
        while (!queue.isEmpty()){
            for(int p = queue.size(); p > 0; p--){
                int crt = queue.poll();
                if(crt == n*n-1) return step;
                for(int m = crt; m <= Math.min(6+crt, n*n-1); m++){
                    int next = moves[m] > -1 ? moves[m]-1 : m;
                    if(seen[next]) continue;
                    queue.offer(next);
                    seen[next] = true;
                }
            }
            step++;
        }
        return -1;
    }
}
