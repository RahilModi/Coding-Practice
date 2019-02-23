package com.programming.leetcode.Medium;

import java.util.*;


public class GraphClone {

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //UndirectedGraphNode clonedGraph = new UndirectedGraphNode(node.label);
        if(node == null) return  null;
        int initNodeLabel = node.label;
        Queue<UndirectedGraphNode> bfs = new ArrayDeque<>();
        Map<Integer, UndirectedGraphNode> nodes = new HashMap<>();
        nodes.put(node.label, new UndirectedGraphNode(node.label));
        bfs.add(node);
        while (!bfs.isEmpty()){
            node = bfs.poll();
            for(UndirectedGraphNode neighbor : node.neighbors){
                if(!nodes.containsKey(neighbor.label)) {
                    nodes.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    bfs.add(neighbor);
                }
                nodes.get(node.label).neighbors.add(nodes.get(neighbor.label));
            }
        }
        return nodes.get(initNodeLabel);
    }

    public static void main(String[] args) {
        UndirectedGraphNode obj = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        obj.neighbors.add(node1);
        obj.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);
        GraphClone mainObj = new GraphClone();
        UndirectedGraphNode res = mainObj.cloneGraph(obj);

    }

}
