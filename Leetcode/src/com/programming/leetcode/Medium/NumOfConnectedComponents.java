package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NumOfConnectedComponents {

    public int countComponents(int num_nodes, int[][]edges){
        int res = num_nodes;
        int[] nodes = IntStream.range(0,num_nodes).toArray();
        for(int[] edge: edges) {
            int x = find(nodes, edge[0]);
            int y = find(nodes, edge[1]);
            if(x != y) {
                res--;
                nodes[y] = x;
            }
        }
        return res;
    }

    private int find(int [] arr, int index){
        while (index != arr[index]) index = arr[index];
        return index;
    }

    public int numComponents(int num_nodes, int[][]edges){
        int res = 0;
        List<Integer>[] map = new ArrayList[num_nodes];

        for(int i = 0 ; i < num_nodes; i++){
            map[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[num_nodes];
        for(int[] edge: edges){
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        for(int i = 0; i < num_nodes; i++){
            if(!visited[i]){
                res++;
                visited[i] = true;
                dfs_helper(i, map, visited);
            }
        }
        return res;
    }

    private void dfs_helper(int crt_node, List<Integer>[] adjacencyList, boolean[] visited){
        for( int edgeNode : adjacencyList[crt_node]){
            if(!visited[edgeNode]) {
                visited[edgeNode] = true;
                dfs_helper(edgeNode, adjacencyList, visited);
            }
        }
        return;
    }




}
