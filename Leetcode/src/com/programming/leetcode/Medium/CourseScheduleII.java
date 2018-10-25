package com.programming.leetcode.Medium;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        Deque<Integer> queue = new LinkedList<Integer>();
        for(int i =0; i< numCourses;i++){
            if(!helperDFS(mapOfVertices, visited, i, queue)){
                return new int[]{};
            }
        }
        int[] res = new int[queue.size()];
        int index = 0;
        for(int i: queue){
            res[index++] = i;
        }
        return res;
    }
    public boolean helperDFS(Map<Integer,List<Integer>> map, Set<Integer> visited, int course, Deque<Integer> queue){
        if(visited.contains(course)) return false;
        if(!map.containsKey(course)) {
            queue.offer(course);
            return true;
        }
        visited.add(course);

        for(Integer prereq : map.get(course)){
            if(!helperDFS(map, visited, prereq, queue)) return false;
        }
        //visited.remove(course);
        queue.offer(course);
        return true;
    }

    public static void main(String[] args) {
        int[] res = new CourseScheduleII().findOrder(2, new int[][]{{1,0}});
        for(int i : res)
            System.out.println(i);
    }
}
