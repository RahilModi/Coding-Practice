package com.programming.leetcode.Easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOrange {

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int countFresh = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    countFresh++;
                }
            }
        }
        if(countFresh == 0) return 0;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()){
            ++count;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] pos = queue.poll();
                for(int[] dir:dirs){
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];

                    if(x < 0 || y < 0 || x >= grid.length || y >= grid.length || grid[x][y] == 0 || grid[x][y] == 2) continue;

                    grid[x][y] = 2;

                    queue.add(new int[]{x,y});
                    countFresh--;
                }
            }
        }
        return countFresh == 0 ? count-1:-1;
    }

    public static void main(String[] args) {
        int[][] input={{2,1,1},{1,1,0},{0,1,1}};
        RottingOrange obj = new RottingOrange();
        System.out.println(obj.orangesRotting(input));
    }

}
