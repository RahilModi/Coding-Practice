package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindEventualSafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] nodeStates = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(nodeStates[i] == 1 || dfs(nodeStates, graph, i)){
                res.add(i);
            }
        }
        return res;
    }

    private boolean dfs(int[] nodeStates, int[][] graph, int crt){
        if(nodeStates[crt] != 0) return nodeStates[crt] == 1;
        nodeStates[crt] = 2;
        for(int i : graph[crt]){
            if(!dfs(nodeStates, graph, i)) return false;
        }
        nodeStates[crt] = 1;
        return true;
    }

    public static void main(String[] args) {
        FindEventualSafeState obj = new FindEventualSafeState();
        System.out.println(obj.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
    }
}
