package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        int m = maze.length, n = maze[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        if(start[0] == destination[0] && start[1] == destination[1]) return 0;
        int[][] distance = new int[m][n];
        for(int[] r: distance) Arrays.fill(r, -1);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        distance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()){
            int[] crt = queue.poll();
            for(int k = 0; k < 4; k++){
                int crtDist = distance[crt[0]][crt[1]];
                int newR = crt[0] + dirs[k], newC = crt[1] + dirs[k+1];
                crtDist++;
                while (newR >= 0 && newC >= 0 && newR < m && newC < n && maze[newR][newC] == 0){
                    newR += dirs[k];
                    newC += dirs[k+1];
                    crtDist++;
                }
                newR -= dirs[k];
                newC -= dirs[k+1];
                crtDist--;
                if(distance[newR][newC] == -1 || distance[newR][newC] > crtDist){
                    queue.add(new int[]{newR, newC});
                    distance[newR][newC] = crtDist;
                }
            }
        }
        return distance[destination[0]][destination[1]];

    }

}
