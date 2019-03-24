package com.programming.leetcode.Hard;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int S, int T) {

        boolean[] seen = new boolean[routes.length];
        if(S == T) return 0;
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                graph.computeIfAbsent(routes[i][j], k -> new ArrayList<>()).add(i);
            }
        }
        queue.add(S);
        while (!queue.isEmpty()){
            res++;
            for(int i = queue.size(); i> 0; i--) {
                int station = queue.poll();
                for (int b : graph.get(station)) {
                    if(!seen[b]){
                        seen[b] = true;
                        for(int nextStation : routes[b]) {
                            if (nextStation == T) return res;
                            queue.offer(nextStation);
                        }
                    }
                }
            }
        }
        return -1;
    }

    //using int[] for [0] = station number and [1] = bus count from the start
    public int numBusesToDestinationV1(int[][] routes, int S, int T) {
        if(S == T) return 0;
        Set<Integer> seen = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < routes.length; i++){
            for(int j : routes[i]){
                graph.computeIfAbsent(j, k -> new HashSet<>()).add(i);
            }
        }
        queue.add(new int[]{S,0});
        seen.add(S);
        while (!queue.isEmpty()){
            for(int i = queue.size(); i> 0; i--) {
                int[] crt = queue.poll();
                if(crt[0] == T) return crt[1];
                for (int route : graph.get(crt[0])) {
                    for(int station : routes[route]){
                        if(!seen.contains(station)){
                            queue.add(new int[]{station, crt[1]+1});
                            seen.add(station);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] routes = {{1,2,7},{3,6,7}};
        System.out.println(new BusRoutes().numBusesToDestination(routes, 1,6));
        System.out.println(new BusRoutes().numBusesToDestinationV1(routes, 1,6));
    }
}
