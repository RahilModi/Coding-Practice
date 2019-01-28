package com.programming.leetcode.Easy;

public class LargestTriangleArea {

    double area(int[] point1, int[] point2, int[] point3){
        return 0.5 * Math.abs( point1[0] * (point2[1] - point3[1]) +
                point2[0] * (point3[1] - point1[1]) +
                point3[0] * (point1[1] - point2[1]));
    }

    public double largestTriangleArea(int[][] points) {
        double ans = Double.MIN_VALUE;
        for(int i = 0; i < points.length - 2; i++){
            for(int j = i+1; j < points.length - 1; j++){
                for(int k = j + 1; k < points.length; k++){
                    ans = Math.max(ans, area(points[i],points[j],points[k]));
                }
            }
        }
        return ans;
    }
}
