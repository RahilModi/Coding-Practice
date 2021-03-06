package com.programming.leetcode.Medium;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> mapConnected =  new HashMap<>();
        for(String[] route : tickets){
            mapConnected.computeIfAbsent(route[0], k->new PriorityQueue<>()).add(route[1]);
        }
        List<String> newItinerary = new ArrayList<>();
        helper("JFK",mapConnected,newItinerary);
        return newItinerary;
    }

    public void helper(String crt_des, Map<String, PriorityQueue<String>> map, List<String> newPath){
        while(map.containsKey(crt_des) && !map.get(crt_des).isEmpty()){
            helper(map.get(crt_des).poll(),map,newPath);
        }
        newPath.add(0,crt_des);
    }

    public List<String> findItineraryV1(String[][] tickets) {
        Map<String, PriorityQueue<String>> mapConnected =  new HashMap<>();
        for(String[] route : tickets){
            mapConnected.computeIfAbsent(route[0], k->new PriorityQueue<>()).add(route[1]);
        }
        List<String> newItinerary = new ArrayList<>();
        dfs("JFK",mapConnected,newItinerary);
        return newItinerary;
    }

    private void dfs(String crtDes, Map<String, PriorityQueue<String>> map, List<String> newItinerary){
        while(map.containsKey(crtDes)){
            String nextDes = map.get(crtDes).poll();
            if(map.get(crtDes).isEmpty()) map.remove(crtDes);
            dfs(nextDes, map, newItinerary);
        }
        newItinerary.add(0, crtDes);
    }

    public static void main(String[] args) {
        ReconstructItinerary obj = new ReconstructItinerary();
        //System.out.println(Arrays.toString(obj.findItinerary(new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}}).toArray()));
        System.out.println(Arrays.toString(obj.findItinerary(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}}).toArray()));
    }

}
