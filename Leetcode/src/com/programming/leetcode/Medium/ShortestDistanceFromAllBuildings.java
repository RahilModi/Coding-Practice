package com.programming.leetcode.Medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ShortestDistanceFromAllBuildings {

    public int shortestDistance(int[][] grid) {
        if(grid == null|| grid.length == 0) return 0;
        final int[] dirs = new int[]{0,1,0,-1,0};
        int numRows = grid.length, numCols = grid[0].length;
        int[][][] distance = new int[2][numRows][numCols];
        int numBuildings = 0;
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(grid[i][j] == 1){
                    numBuildings++;
                    Set<String> seen =new HashSet<>();
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i,j});
                    seen.add(i+"-"+j);
                    int level = 1;
                    while (!queue.isEmpty()){
                        for(int q = queue.size(); q > 0; q--){
                            int[] crtPos = queue.poll();
                            int k = 0;
                            for(int d = 0; d < 4; d++,k++){
                                int newX = crtPos[0] + dirs[k];
                                int newY = crtPos[1] + dirs[k+1];
                                if(newX < 0 || newY < 0 || newX >= numRows || newY >= numCols || grid[newX][newY] != 0 || !seen.add(newX+"-"+newY)) continue;
                                distance[0][newX][newY] += level;
                                distance[1][newX][newY]++;
                                queue.offer(new int[]{newX, newY});
                            }
                        }
                        level++;
                    }
                }
            }
        }

        int shortestDist = Integer.MAX_VALUE;
        for(int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if(grid[i][j] == 0 && distance[1][i][j] == numBuildings){
                    shortestDist = Math.min(shortestDist, distance[0][i][j]);
                }
            }
        }

        return shortestDist == Integer.MAX_VALUE ? -1 : shortestDist;
    }

    public static void main(String[] args) {
        int[][] buildingMap = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        ShortestDistanceFromAllBuildings obj = new ShortestDistanceFromAllBuildings();
        System.out.println(obj.shortestDistance(buildingMap));
    }
}
