package com.programming.leetcode.Medium;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/discuss/93703/Share-my-explained-Greedy-solution
public class MinArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if(points.length < 2) return  points.length;
        Arrays.sort(points, (a,b)->a[1]-b[1]);
        int arrowPos = points[0][1];
        int count = 1;
        for(int i = 1; i < points.length; i++){
            if(arrowPos < points[i][0]){
                arrowPos = points[i][1];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{2,6},{1,6},{2,8},{7,12},{10,18}};
        System.out.println(new MinArrowsToBurstBalloons().findMinArrowShots(input));
    }


}
