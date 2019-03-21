package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PossibleBipartition {

    //like graph bipartite..
    //group[i] = 0 means node i hasn't been visited.
    //group[i] = 1 means node i has been grouped to 1.
    //group[i] = -1 means node i has been grouped to -1.

    public boolean possibleBipartition(int N, int[][] dislikes) {

        int[][] graph = new int[N][N];
        int[] group = new int[N];
        for(int[] dislike : dislikes){
            graph[dislike[0]-1][dislike[1]-1] = 1;
            graph[dislike[1]-1][dislike[0]-1] = 1;
        }

        for(int i = 0; i<N; i++){
            if(group[i] == 0 && !dfs(graph, group, i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] group, int crtIndex, int val){
        group[crtIndex] = val;
        for(int i = 0; i < graph.length; i++){
            if(graph[crtIndex][i] == 1){
                if(group[i] == val || (group[i] == 0 && !dfs(graph, group, i, -val))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] dislikes = {{1,2},{1,3},{2,4}};
        PossibleBipartition obj = new PossibleBipartition();
        System.out.println(obj.possibleBipartition(4,dislikes));
    }

}
