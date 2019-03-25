package com.programming.leetcode.Hard;

import java.util.*;

public class ShortestPathVisitingAllNodes {

    class Node{
        int numVisited, cost, nodeNum;

        public Node(int numVisited, int cost, int nodeNum) {
            this.numVisited = numVisited;
            this.cost = cost;
            this.nodeNum = nodeNum;
        }

        public Node(int numVisited, int nodeNum) {
            this.numVisited = numVisited;
            this.cost = 0;
            this.nodeNum = nodeNum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return numVisited == node.numVisited &&
                    cost == node.cost &&
                    nodeNum == node.nodeNum;
        }

        @Override
        public int hashCode() {
            return 1331 * this.numVisited + 7193 * this.nodeNum + 727 * this.cost;
        }
    }

    public int shortestPathLength(int[][] graph) {

        int N = graph.length;
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        for(int i = 0; i < N; i++){
            queue.offer(new Node(1<<i,  i));
            visited.add(new Node(1<<i,  i));
        }

        while (!queue.isEmpty()){
            Node crt = queue.poll();
            if(crt.numVisited == (1 << N)-1){
                return crt.cost;
            }
            for(int nextNode: graph[crt.nodeNum]){
                int bitmask = crt.numVisited;
                bitmask |= (1<<nextNode);
                Node next = new Node(bitmask, nextNode);
                if(!visited.contains(next)){
                    queue.add(new Node(bitmask,crt.cost+1,nextNode));
                    visited.add(next);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathVisitingAllNodes obj = new ShortestPathVisitingAllNodes();
        System.out.println(obj.shortestPathLength(new int[][]{{1,2,3},{0},{0},{0}}));
    }

}
