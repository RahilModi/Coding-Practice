package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedFromSameRowAndCols {

    Map<Integer,Integer> map = new HashMap<>();
    int islands = 0;
    public int removeStones(int[][] stones) {

        for(int[] stone: stones){
            union(stone[0],~stone[1]);
        }
        return stones.length-islands;
    }

    private int find(int x){
        if(map.putIfAbsent(x, x) == null){
            islands++;
        }
        if(x != map.get(x)){
            map.put(x, find(map.get(x)));
        }
        return map.get(x);
    }

    private void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!= y){
            map.put(x, y);
            islands--;
        }
    }



    public int removeStonesV1(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int numIslands = 0;
        for(int[] stone: stones){
            if(!visited.contains(stone)){
                dfs(stones, stone, visited);
                numIslands++;
            }
        }
        return stones.length - numIslands;
    }

    private void dfs(int[][] stones, int[] s1, Set<int[]> visited){
        visited.add(s1);
        for(int[] s2: stones){
            if(!visited.contains(s2)){
                if(s1[0] == s2[0] || s1[1] == s2[1]){
                    dfs(stones, s2, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        MostStonesRemovedFromSameRowAndCols obj = new MostStonesRemovedFromSameRowAndCols();
        System.out.println(obj.removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
    }

}
