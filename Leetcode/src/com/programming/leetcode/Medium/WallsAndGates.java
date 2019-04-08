package com.programming.leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j]==0) q.add(new int[]{i,j});
            }
        }

        while (!q.isEmpty()){
            int[]crt = q.poll();
            if(crt[0] > 0 && rooms[crt[0]-1][crt[1]] == Integer.MAX_VALUE){
                rooms[crt[0]-1][crt[1]] = rooms[crt[0]][crt[1]]+1;
                q.add(new int[]{crt[0]-1,crt[1]});
            }
            if(crt[1] > 0 && rooms[crt[0]][crt[1]-1] == Integer.MAX_VALUE){
                rooms[crt[0]][crt[1]-1] = rooms[crt[0]][crt[1]]+1;
                q.add(new int[]{crt[0],crt[1]-1});
            }
            if(crt[0] < rooms.length-1 && rooms[crt[0]+1][crt[1]] == Integer.MAX_VALUE){
                rooms[crt[0]+1][crt[1]] = rooms[crt[0]][crt[1]]+1;
                q.add(new int[]{crt[0]+1,crt[1]});
            }
            if(crt[1] < rooms[0].length && rooms[crt[0]][crt[1]+1] == Integer.MAX_VALUE){
                rooms[crt[0]][crt[1]+1] = rooms[crt[0]][crt[1]]+1;
                q.add(new int[]{crt[0],crt[1]+1});
            }
        }
    }

}
