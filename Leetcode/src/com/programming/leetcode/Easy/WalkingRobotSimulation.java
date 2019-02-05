package com.programming.leetcode.Easy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WalkingRobotSimulation {
    static class Point{
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Point> obstaclesSet = new HashSet<>();
        for(int[] obstacle : obstacles) {
            obstaclesSet.add(new Point(obstacle[0],obstacle[1]));
        }
        Point initPos = new Point(0,0);
        boolean moveX = false, moveY = true;
        int numXMoves = 0, numYMoves = 1, max_area = 0;
        for(int instruction : commands){
            if(instruction==-1 || instruction ==-2) {
                if(instruction == -2) {
                    if (moveY) {
                        numXMoves = (numYMoves == 1) ? -1 : 1;
                        numYMoves = 0;
                    } else {
                        numYMoves = (numXMoves == 1) ? 1 : -1;
                        numXMoves = 0;
                    }
                }else {
                    if (moveY) {
                        numXMoves = (numYMoves == 1) ? 1 : -1;
                        numYMoves = 0;
                    } else {
                        numYMoves = (numXMoves == 1) ? -1 : 1;
                        numXMoves = 0;
                    }
                }
                moveX = !moveX;
                moveY = !moveY;
            }else {
                for(int i = 0; i < instruction; i++){
                    int nx = initPos.x, ny = initPos.y;
                    if(moveX){
                        nx += (numXMoves);
                    }else{
                        ny += (numYMoves);
                    }
                    if(!obstaclesSet.contains(new Point(nx,ny))){
                        max_area = Math.max(max_area, nx*nx + ny*ny);
                        initPos.x = nx;
                        initPos.y = ny;
                    }
                }
            }
        }
        return max_area;
    }

    public static void main(String[] args) {
        WalkingRobotSimulation walkingRobotSimulation = new WalkingRobotSimulation();
        System.out.println(walkingRobotSimulation.robotSim(new int[]{4,-1,4,-2,4}, new int[][]{{2,4}}));
        System.out.println(walkingRobotSimulation.robotSim(new int[]{4,-1,3}, new int[][]{}));
    }
}
