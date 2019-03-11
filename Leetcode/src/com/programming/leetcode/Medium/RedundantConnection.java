package com.programming.leetcode.Medium;

import java.util.Arrays;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] nodes = new int[edges.length + 1];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = i;
        }
        for (int[] edge : edges) {
            int parentOfX = find(nodes, edge[0]);
            int parentOfY = find(nodes, edge[1]);
            if (parentOfX != parentOfY) {
                nodes[parentOfY] = parentOfX;
            } else {
                return edge;
            }
        }
        return new int[2];
    }

    public int find(int[] nodes, int x){
        if(x != nodes[x]) {
            nodes[x] = find(nodes, nodes[x]);
        }
        return nodes[x];
    }

    public static void main(String[] args) {
        RedundantConnection obj = new RedundantConnection();
        System.out.println(Arrays.toString(obj.findRedundantConnection(new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}})));
    }
}
