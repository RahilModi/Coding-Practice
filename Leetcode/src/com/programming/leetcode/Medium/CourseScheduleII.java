package com.programming.leetcode.Medium;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) return IntStream.range(0,numCourses).map(i -> numCourses - i - 1).toArray();
        int[] coursesInDegrees = new int[numCourses];
        Map<Integer,List<Integer>> coursesPrerequsiteMap = new HashMap<>();
        for(int[] pair:prerequisites){
            coursesInDegrees[pair[0]]++;
            List<Integer> list = coursesPrerequsiteMap.get(pair[0]);
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(pair[1]);
            coursesPrerequsiteMap.put(pair[0],list);
        }

        Deque<Integer> courseOrder = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> loop = new HashSet<>();
        for(int i = 0; i < coursesInDegrees.length; i++){
            if(coursesInDegrees[i]==0){
                visited.add(i);
                courseOrder.offer(i);
            }
        }
        for(int course: coursesPrerequsiteMap.keySet()){
            if(visited.contains(course)) continue;
            if(!helperDFS(coursesPrerequsiteMap,visited,course,courseOrder, loop)){
                return new int[]{};
            }
        }
        return courseOrder.stream().mapToInt(i->i).toArray();
    }
    public boolean helperDFS(Map<Integer,List<Integer>> map, Set<Integer> visited, int course, Deque<Integer> queue, Set<Integer> loop){
        visited.add(course);
        loop.add(course);
        for(int crt_course_id : map.get(course)){
            if(loop.contains(crt_course_id)) return false;
            if(!visited.contains(crt_course_id)){
                if(!helperDFS(map,visited,crt_course_id,queue,loop)){
                    return false;
                }
            }
        }
        loop.remove(course);
        queue.offer(course);
        return true;
    }


    public int[] findOrder_BFS(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) return IntStream.range(0,numCourses).map(i -> numCourses - i - 1).toArray();
        int[] coursesInDegrees = new int[numCourses];
        Map<Integer,List<Integer>> coursesPrerequsiteMap = new HashMap<>();
        for(int[] pair:prerequisites){
            coursesInDegrees[pair[0]]++;
            List<Integer> list = coursesPrerequsiteMap.get(pair[1]);
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(pair[0]);
            coursesPrerequsiteMap.put(pair[1],list);
        }

        Deque<Integer> courseOrder = new ArrayDeque<>();
        for(int i = 0; i < coursesInDegrees.length; i++){
            if(coursesInDegrees[i]==0){
                courseOrder.offer(i);
            }
        }
        int order[] = new int[numCourses];
        int visited = 0;
        while(!courseOrder.isEmpty()){
            int crt_course =  courseOrder.poll();
            order[visited++] = crt_course;
            if(coursesPrerequsiteMap.get(crt_course) != null) {
                for (int dependents : coursesPrerequsiteMap.get(crt_course)) {
                    --coursesInDegrees[dependents];
                    if (coursesInDegrees[dependents] == 0) courseOrder.offer(dependents);
                }
            }
        }
        return visited == numCourses ? order : new int[0];
    }


    public int[] findOrderV2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preReqMap = new HashMap<>();
        for(int[] prereq : prerequisites){
            preReqMap.computeIfAbsent(prereq[1], k -> new ArrayList<>()).add(prereq[0]);
        }

        boolean[] seen = new boolean[numCourses];
        Stack<Integer> seq = new Stack<>();
        for(int i = 0; i < numCourses; i++){
            if(!seen[i]){
                if(!topologicalSort(preReqMap, seen, new HashSet<>(), i, seq)){
                    return new int[]{};
                }
            }
        }
        int[] res = new int[seq.size()];
        int i = 0;
        while(!seq.isEmpty()){
            res[i++] = seq.pop();
        }
        return res;
    }

    private boolean topologicalSort(Map<Integer, List<Integer>> map, boolean[] visited, Set<Integer> crtLoop, int key, Stack<Integer> seq){
        crtLoop.add(key);
        visited[key] = true;
        if(map.containsKey(key)){
            for(Integer dep : map.get(key)){
                if(crtLoop.contains(dep)) return false;
                if(!visited[dep]){
                    if(!topologicalSort(map, visited, crtLoop, dep,seq)){
                        return false;
                    }
                }
            }
        }
        crtLoop.remove(key);
        seq.push(key);
        return true;
    }

    public static void main(String[] args) {
        int[] res;
        res = new CourseScheduleII().findOrderV2(2, new int[][]{{1,0}});
        System.out.println(Arrays.toString(res));
        res = new CourseScheduleII().findOrder(3,new int[][]{{2,0},{2,1}});
        System.out.println(Arrays.toString(res));
        res = new CourseScheduleII().findOrder(2, new int[][]{{1,0}});
        System.out.println(Arrays.toString(res));
        res = new CourseScheduleII().findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        System.out.println(Arrays.toString(res));
        res = new CourseScheduleII().findOrder(2,new int[][]{{0,1},{1,0}});
        System.out.println(Arrays.toString(res));

        res = new CourseScheduleII().findOrder_BFS(3,new int[][]{{2,0},{2,1}});
        System.out.println(Arrays.toString(res));
        res = new CourseScheduleII().findOrder_BFS(2, new int[][]{{1,0}});
        System.out.println(Arrays.toString(res));
        res = new CourseScheduleII().findOrder_BFS(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        System.out.println(Arrays.toString(res));
        res = new CourseScheduleII().findOrder_BFS(2,new int[][]{{0,1},{1,0}});
        System.out.println(Arrays.toString(res));

    }
}
