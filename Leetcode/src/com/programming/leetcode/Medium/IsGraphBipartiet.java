package com.programming.leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartiet {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for(int i = 0; i<n; i++){
            if(colors[i] == 0 && !dfs(graph, colors, 1, i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph,  int[] colors, int colorVal, int nodeVal){
        if(colors[nodeVal] != 0){
            return colors[nodeVal] == colorVal;
        }
        colors[nodeVal]=colorVal;

        for(int node: graph[nodeVal]){
            if(!dfs(graph, colors, -colorVal, node)){
                return false;
            }
        }
        return true;
    }

    public boolean isBipartiteBFS(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < len; i++) {
            if (colors[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;   // Blue: 1; Red: -1.

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {          // If this node hasn't been colored;
                        colors[next] = -colors[cur];  // Color it with a different color;
                        queue.offer(next);
                    } else if (colors[next] != -colors[cur]) {   // If it is colored and its color is different, return false;
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
