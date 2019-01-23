package com.programming.leetcode.Easy;

import java.util.*;

public class NetworkDelayTime {

    Map<Integer, List<int[]>> adjList = new HashMap<>();
    public int networkDelayTime(int[][] times, int N, int K) {
        for(int[] edge: times){
            List<int[]> t = adjList.get(edge[0]);
            if(t == null){
                t = new ArrayList<>();
            }
            t.add(new int[]{edge[1],edge[2]});
            adjList.put(edge[0],t);
        }
        List<int[]> edges = adjList.get(K);
        if(edges == null) return -1;
        int[]dist = new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[K-1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(K);

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            int t = dist[node-1];
            edges = adjList.get(node);
            if(edges==null) continue;
            for(int[] n:edges){
                int v = n[0];
                int time = n[1];
                if(dist[v-1] > t + time){
                    dist[v-1] = t+time;
                    queue.offer(v);
                }
            }
        }

        int max = Arrays.stream(dist).max().getAsInt();
        return max == Integer.MAX_VALUE ? -1: max;

    }

    public static void main(String[] args) {
        new NetworkDelayTime().networkDelayTime(new int[][]{
                {2,1,1},{2,3,1},{3,4,1}
        },4,2);
    }
}
