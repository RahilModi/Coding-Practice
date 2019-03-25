package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()){
            int[] crt = queue.poll();
            for(int k = 0; k < 4; k++){
                int newR = crt[0] + dirs[k], newC = crt[1] + dirs[k+1];
                while (newR >= 0 && newC >= 0 && newR < m && newC < n && maze[newR][newC] == 0){
                    newR += dirs[k];
                    newC += dirs[k+1];
                }
                newR -= dirs[k];
                newC -= dirs[k+1];
                if(visited[newR][newC])continue;
                visited[newR][newC] = true;
                if(newR == destination[0] && newC == destination[1]) return true;
                queue.offer(new int[]{newR, newC});
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][]maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        for(int[] r : maze) System.out.println(Arrays.toString(r));
        TheMaze obj = new TheMaze();
        System.out.println(obj.hasPath(maze, new int[]{0,4}, new int[]{3,2}));
    }

}
