package com.programming.leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    private final int[] dirs = {0,1,0,-1,0};
    public int shortestBridge(int[][] A) {
        if(A == null || A.length == 0) return -1;
        boolean[][] seen = new boolean[A.length][A[0].length];
        Queue<int[]> queue = new LinkedList<>();
        boolean bIslandFound = false;
        for(int i = 0; i < A.length && !bIslandFound; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] == 1){
                    dfs(A, i,j,seen,queue);
                    bIslandFound = true;
                    break;
                }
            }
        }

        int step = 0;
        while (!queue.isEmpty()){
            int crtSize = queue.size();
            while (crtSize-- > 0){
                int[] crtPos = queue.poll();
                int k = 0;
                while (k < dirs.length-1){
                    int newX = crtPos[0]+dirs[k], newY = crtPos[1]+dirs[k+1];
                    if(newX >= 0 && newY >= 0 && newX < A.length && newY < A[0].length && !seen[newX][newY]){
                        if(A[newX][newY] == 1) return step;
                        queue.offer(new int[]{newX,newY});
                        seen[newX][newY] =true;
                    }
                    k++;
                }
            }
            step++;
        }

        return -1;
    }

    private void dfs(int[][] A, int i, int j, boolean[][] seen, Queue<int[]> queue){
        if(i < 0|| j < 0 || i >= A.length || j >= A[0].length || A[i][j] == 0 || seen[i][j]) return;
        seen[i][j] = true;
        queue.add(new int[]{i,j});
        int k = 0;
        while (k < dirs.length-1){
            dfs(A, i+dirs[k], j + dirs[k+1], seen,queue);
            k++;
        }
    }

    public static void main(String[] args) {
        ShortestBridge obj = new ShortestBridge();
        System.out.println(obj.shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}}));
    }
}
