package com.programming.leetcode.Medium;

import java.util.*;

public class CourseraTaskMasterProblem {
    static int count = 0;
    public int tasks(int n, List<Integer> a, List<Integer> b) {
        if (a == null || a.size() == 0 || b == null || b.size() == 0) return n;

        Map<Integer, List<Integer>> taskDependecyMapping = new HashMap<>();
        for (int i = 0; i < b.size(); i++) {
            List<Integer> dependency_list;
            if (taskDependecyMapping.containsKey(b.get(i))) {
                dependency_list = taskDependecyMapping.get(b.get(i));
                dependency_list.add(a.get(i));
            } else {
                dependency_list = new ArrayList<>();
                dependency_list.add(a.get(i));
            }
            taskDependecyMapping.put(b.get(i), dependency_list);
        }
        Set<Integer> visited = new HashSet<>();
        for(int key : taskDependecyMapping.keySet()){
            if(visited.contains(key)){
                continue;
            }else {
                count++;
                helper(key, taskDependecyMapping, visited);
            }
        }
        for(int i = 1; i <= n; i++){
            if(!visited.contains(i)) count++;
        }
        return count;
    }

    static void helper(int i, Map<Integer,List<Integer>> map, Set<Integer> visitedSet){
        visitedSet.add(i);
        if(map.containsKey(i)) {
            for (int j : map.get(i)) {
                if (visitedSet.contains(j)) {
                    continue;
                } else {
                    count++;
                    helper(j, map, visitedSet);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(6);
        List<Integer> b = new ArrayList<>();
        b.add(7);
        b.add(6);
        b.add(4);
        b.add(1);
        b.add(2);
        System.out.println(new CourseraTaskMasterProblem().tasks(7, a,b));
    }


}
