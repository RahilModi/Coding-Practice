package com.programming.leetcode.Medium;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/***
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 * For example:
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * Hint:
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
 * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
 *
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * Refere: http://www.cnblogs.com/grandyang/p/5257919.html for C++ implementations
 */

public class GraphValidTree {

    //UNION FIND APPROACH
    public boolean validTree(int num_nodes, int[][] edges){

        int[] nodes = IntStream.generate(()->-1).limit(num_nodes).toArray();

        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];

            x = parent(nodes, x);
            y = parent(nodes, y);

            if(x == y) return false;

            nodes[x] = y;
        }

        return edges.length == num_nodes-1;

    }

    public int parent(int[] nums, int index){
        while(nums[index]!=-1)index=nums[index];
        return index;
    }

    //DEPTH FIRST SEARCH
    public boolean isValidTree(int num_nodes, int[][]edges){
        List<Integer>[] map = new ArrayList[num_nodes];

        for(int i = 0 ; i < num_nodes; i++){
            map[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[num_nodes];
        for(int[] edge: edges){
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        if(!dfs_helper(0,-1,map,visited)) return false;

        for(boolean val : visited){
            if(!val) return false;
        }

        return true;

    }

    public boolean dfs_helper(int crt_node, int prev, List<Integer>[] adjacencyList, boolean[] visited){
        if(visited[crt_node]) return false;
        visited[crt_node] = true;
        for( int edgeNodes : adjacencyList[crt_node]){
            if(edgeNodes != prev){
                if(!dfs_helper(edgeNodes,crt_node,adjacencyList,visited))
                    return false;
            }
        }
        return true;
    }


    //DEPTH FIRST SEARCH
    public boolean isValidTree_BFS(int num_nodes, int[][]edges){
        List<Integer>[] map = new ArrayList[num_nodes];
        for(int i = 0 ; i < num_nodes; i++){
            map[i] = new ArrayList<>();
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> fifo_queue = new LinkedList<>();
        for(int[] edge: edges){
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        fifo_queue.offer(0);
        visited.add(0);
        while(!fifo_queue.isEmpty()){
            int crt_node = fifo_queue.poll();
            for(int edge: map[crt_node]){
                if(visited.contains(edge)) return false;
                visited.add(edge);
                fifo_queue.offer(edge);
                map[edge].remove(new Integer(crt_node));
            }
        }

        return visited.size() == num_nodes;
    }



    public static void main(String[] args) {
        GraphValidTree obj = new GraphValidTree();
        System.out.println(obj.validTree(5,new int[][]{{0,1},{1,3},{0,4},{0,2}}));
        System.out.println(obj.isValidTree(5,new int[][]{{0,1},{2,3},{0,4},{0,2}}));
        System.out.println(obj.isValidTree_BFS(5,new int[][]{{0,1},{2,3},{0,4},{0,3}}));
    }
}
