package com.programming.leetcode.Medium;

import java.util.*;

public class AllpathsFromSourceTotarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if(graph==null|| graph.length==0)return res;
        List<Integer> crt = new ArrayList<>();
        crt.add(0);
        dfs(0, crt, res,graph);
        return res;
    }

    public void dfs(int v, List<Integer> path, List<List<Integer>> res, int[][] graph){
        if(v == graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int next : graph[v]){
            path.add(next);
            dfs(next,path,res,graph);
            path.remove(path.size()-1);
        }
        return;
    }

    public static void main(String[] args) {
        AllpathsFromSourceTotarget obj = new AllpathsFromSourceTotarget();
        obj.allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}}).forEach( l -> System.out.println(l));
    }
}
