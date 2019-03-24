package com.programming.leetcode.Medium;

import java.util.*;
import java.util.stream.Collectors;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.isEmpty()) return true;
        boolean[] keys = new boolean[rooms.size()];
        dfs(0, rooms, keys);
        for(int i = 0; i < rooms.size(); i++){
            if(!keys[i]) return false;
        }
        return true;
    }

    private void dfs(int k, List<List<Integer>> rooms, boolean[] visited){
        visited[k] = true;
        for(int key : rooms.get(k)){
            if(!visited[key]){
                dfs(key, rooms, visited);
            }
        }
    }

    //Iterative..
    public boolean canVisitAllRoomsV1(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>(); stack.add(0);
        HashSet<Integer> seen = new HashSet<>(); seen.add(0);
        while (!stack.isEmpty()) {
            if(rooms.size() == seen.size()) return true;
            int i = stack.pop();
            for (int j : rooms.get(i))
                if (!seen.contains(j)) {
                    stack.add(j);
                    seen.add(j);
                }
        }
        return rooms.size() == seen.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.stream(new int[]{1,3}).boxed().collect(Collectors.toList()));
        rooms.add(Arrays.stream(new int[]{3,2,1}).boxed().collect(Collectors.toList()));
        rooms.add(Arrays.stream(new int[]{2}).boxed().collect(Collectors.toList()));
        rooms.add(Arrays.stream(new int[]{0}).boxed().collect(Collectors.toList()));
        System.out.println(new KeysAndRooms().canVisitAllRooms(rooms));
    }
}
