package com.programming.leetcode.Hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathToGetAllKeys {

    public int shortestPathAllKeys(String[] grid) {
        int x=-1,y=-1, max=0;
        for(int i = 0; i < grid.length; i++){
            for(int j =0; j <grid[i].length(); j++ ){
                if(grid[i].charAt(j) == '@'){ x = i; y = j;}
                if(grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') max= Math.max(grid[i].charAt(j)-'a'+1, max);
            }
        }

        Set<String> seen = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y,0});
        seen.add(0+"--"+x+"--"+y);
        int step = 0;
        int[] moves =  {0,1,0,-1,0};
        while (!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                int[] crt = queue.poll();
                if(crt[2] == (1 << max)-1) return step;
                for(int k = 0; k < 4; k++){
                    int newR = crt[0] + moves[k];
                    int newC = crt[1] + moves[k+1];
                    int keys = crt[2];
                    if(newR >=0 && newC >= 0 && newR < grid.length && newC < grid[newR].length()){
                        char c = grid[newR].charAt(newC);
                        if(c == '#') continue;
                        if(c >= 'a' && c <= 'f') keys |= 1 << (c -'a');
                        if(c >= 'A' && c <= 'F' && (keys >> (c-'A') & 1) == 0) continue;
                        if(!seen.contains(keys+"--"+newR+"--"+newC)) {
                            seen.add(keys+"--"+newR + "--" + newC);
                            queue.offer(new int[]{newR, newC, keys});
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathToGetAllKeys obj = new ShortestPathToGetAllKeys();
        System.out.println(obj.shortestPathAllKeys(new String[]{"@..aA","..B#.","....b"}));
    }
}
