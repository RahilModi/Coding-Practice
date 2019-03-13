package com.programming.leetcode.Medium;

import com.programming.leetcode.Easy.MajorityElement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinAreaOfRectangle {

    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> pointsRef = new HashMap<>();
        for(int[] p : points){
            pointsRef.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
        }
        int minArea = Integer.MAX_VALUE;
        for(int[] p1 : points){
            for(int[] p2 : points){
                if(p1[0] == p2[0] || p1[1] == p2[1]) continue; //skip [1,1] , [1,3]  OR [3,1] ,[3,3] pairs
                //Calculate for [1,3] and [3,1] points pair of rectangle [1,1],[1,3],[3,1],[3,3]
                if(pointsRef.get(p1[0]).contains(p2[1]) && pointsRef.get(p2[0]).contains(p1[1])){
                    int area = Math.abs(p1[0] - p2[0]) * Math.abs(p1[1]-p2[1]);
                    minArea = Math.min(minArea, area);
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

}
