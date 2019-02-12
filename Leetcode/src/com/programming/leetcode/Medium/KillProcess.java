package com.programming.leetcode.Medium;

import java.util.*;

public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer,List<Integer>> dependencyMap = new HashMap<>();
        int id = 0;
        for(int parent : ppid){
            dependencyMap.computeIfAbsent(parent, k-> new ArrayList<>()).add(pid.get(id++));
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(kill);
        while (!q.isEmpty()){
            Integer proc = q.poll();
            if(dependencyMap.containsKey(proc)) {
                for (int d : dependencyMap.get(proc)) {
                    q.offer(d);
                }
            }
            res.add(proc);
        }
        return res;
    }

    public static void main(String[] args) {
        KillProcess obj = new KillProcess();
        System.out.println(obj.killProcess(Arrays.asList(new Integer[]{1,3,10,5}), Arrays.asList(new Integer[]{3,0,5,3}), 5));
    }

}
