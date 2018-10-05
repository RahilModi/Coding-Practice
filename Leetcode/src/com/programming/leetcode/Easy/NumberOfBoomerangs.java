package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

//bit tricky problem statement and used discussion forum
public class NumberOfBoomerangs {

    static class point{
        int x, y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int distance(point a, point b){
        return (int) (Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static int numberOfBoomerangs(int[][] points) {

        Map<Integer, Integer> res = new HashMap<>();

        int ans = 0;

        for(int i = 0; i< points.length; i++){
            for(int j = 0; j < points.length ; j++){
                if(i == j) continue;

                int distance = (int) distance(new point(points[i][0],points[i][1]), new point(points[j][0],points[j][1]));

                res.put(distance, res.getOrDefault(distance,0)+1);
            }
            for(int num : res.values()){
                ans += num * (num-1);
            }
            res.clear();
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(NumberOfBoomerangs.numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}}));

    }

}
