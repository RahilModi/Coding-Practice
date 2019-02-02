package com.programming.leetcode.Medium;
import sun.security.krb5.internal.crypto.Des;

import java.util.*;

public class CheapestFlightWithKStops {
    static class Destination{
        Integer id, travel_cost, level;
        public Integer getId() {
            return id;
        }
        public Integer getTravel_cost() {
            return travel_cost;
        }
        public Destination(Integer id, Integer travel_cost) {
            this.id = id;
            this.travel_cost = travel_cost;
        }

        public Destination(Integer id, Integer travel_cost, Integer level) {
            this.id = id;
            this.travel_cost = travel_cost;
            this.level = level;
        }

        @Override
        public String toString() {
            return "Destination{" +
                    "id=" + id +
                    ", travel_cost=" + travel_cost +
                    '}';
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<Destination>> timeTable = new HashMap<>();
        for(int[] route : flights){
            timeTable.computeIfAbsent(route[0], k -> new ArrayList<>())
                    .add(new Destination(route[1],route[2]));
        }
        if(!timeTable.containsKey(src)) return -1;
        Queue<Destination> queue = new PriorityQueue<>((a,b)->Integer.compare(a.travel_cost,b.travel_cost));
        queue.add(new Destination(src,0,0));
        int route_cost = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int crt_quue_size =  queue.size();
            while (crt_quue_size > 0) {
                Destination crt_node = queue.poll();
                int stop = crt_node.level;
                if ( crt_node.id == dst) return crt_node.travel_cost;
                if (stop <= K) {
                    List<Destination> pq = timeTable.get(crt_node.id);
                    for (Destination t : pq) {
                        queue.add(new Destination(t.id, t.travel_cost + crt_node.travel_cost, stop + 1));
                    }
                }
                crt_quue_size--;
            }
        }
    return route_cost == Integer.MAX_VALUE ? -1 : route_cost;
    }

    public static void main(String[] args) {
        CheapestFlightWithKStops obj =new CheapestFlightWithKStops();
        System.out.println(obj.findCheapestPrice(5, new int[][]{{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}},0,2,2));
    }
}
