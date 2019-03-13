package com.programming.leetcode.Medium;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mapOfVertices = new HashMap<>();

        for(int[] mapping : prerequisites){
            if(mapOfVertices.containsKey(mapping[1])){
               mapOfVertices.get(mapping[1]).add(mapping[0]);
            }else{
                List<Integer> arrList = new ArrayList<>();
                arrList.add(mapping[0]);
                mapOfVertices.put(mapping[1], arrList);
            }
        }

        Set<Integer> visited = new HashSet<>();

        for(int i =0; i< numCourses;i++){
            if(!helperDFS(mapOfVertices, visited, i)){
                return false;
            }
        }
        return true;
    }

    public boolean helperDFS(Map<Integer,List<Integer>> map, Set<Integer> visited, int course){
        if(visited.contains(course)) return false;
        if(!map.containsKey(course)) return true;
        visited.add(course);

        for(Integer prereq : map.get(course)){
            if(!helperDFS(map, visited, prereq)) return false;
        }
        visited.remove(course);
        return true;
    }

    public boolean canFinishV1(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> preReqMap = new HashMap<>();
        for(int[] prereq : prerequisites){
            preReqMap.computeIfAbsent(prereq[1], k -> new ArrayList<>()).add(prereq[0]);
        }

        boolean[] seen = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!seen[i]){
                if(!topologicalSort(preReqMap, seen, new HashSet<>(), i)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean topologicalSort(Map<Integer, List<Integer>> map, boolean[] visited, Set<Integer> crtLoop, int key){
        crtLoop.add(key);
        visited[key] = true;
        if(map.containsKey(key)){
            for(Integer dep : map.get(key)){
                if(crtLoop.contains(dep)) return false;
                if(!visited[dep]){
                    if(!topologicalSort(map, visited, crtLoop, dep)){
                        return false;
                    }
                }
            }
        }
        crtLoop.remove(key);
        return true;
    }

    public static void main(String[] args) {
        new CourseSchedule().canFinish(2, new int[][]{{1,0},{0,1}});
    }

}
