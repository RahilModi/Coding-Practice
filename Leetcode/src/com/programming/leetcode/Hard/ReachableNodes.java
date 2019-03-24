package com.programming.leetcode.Hard;

import java.util.*;

public class ReachableNodes {

    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Map<Integer,Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1],edge[2]);
            graph.computeIfAbsent(edge[1], k -> new HashMap<>()).put(edge[0],edge[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        pq.offer(new int[]{0,M});
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        while (!pq.isEmpty()){
            int moves = pq.peek()[1], start = pq.peek()[0];
            pq.poll();
            if(!visited.contains(start)){
                visited.add(start);
                res++;
                if(graph.containsKey(start)){
                    for(int nextV : graph.get(start).keySet()){
                        int nextM = moves - graph.get(start).get(nextV) -1;
                        if(!visited.contains(nextV) && nextM >= 0){
                            pq.offer(new int[]{nextV, nextM});
                        }
                        int numVisistedInThisRun =  Math.min(moves, graph.get(start).get(nextV));
                        graph.get(nextV).put(start, graph.get(nextV).get(start)- numVisistedInThisRun);
                        res +=  numVisistedInThisRun;
                    }
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,10},{0,2,1},{1,2,2}};
        int M = 6, N = 3;
        ReachableNodes obj = new ReachableNodes();
        System.out.println(obj.reachableNodes(edges, M, N));
    }

}
