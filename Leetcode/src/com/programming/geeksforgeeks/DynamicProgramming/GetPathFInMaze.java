package com.programming.geeksforgeeks.DynamicProgramming;

import java.util.*;

//Cracking the coding interview Cha[ter 8 : Problem 2
public class GetPathFInMaze {
    class Point{
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

    //O(2^(r+c))
    List<Point> getPath(boolean[][]maze){
        List<Point> res = new ArrayList<>();
        if(maze == null || maze.length == 0) return res;
        if(helper(maze, maze.length-1, maze[0].length-1, res, new HashSet<>()))
            return res;
        return null;
    }

    private boolean helper(boolean[][] maze, int row, int col, List<Point> path, Set<Point> seen){
        if(row <0|| col < 0 || !maze[row][col]) return false;

        Point p = new Point(row, col);

        if(seen.contains(p))return false;

        boolean isAtOrigin = row == 0 && col == 0;
        if(isAtOrigin || helper(maze, row-1, col, path, seen) || helper(maze, row, col-1, path, seen)){
            path.add(p);
            return true;
        }
        seen.add(p);
        return false;
    }


    //O(X*Y)
    List<Point> getPathV1(boolean[][]maze){
        List<Point> res = new ArrayList<>();
        if(maze == null || maze.length == 0) return res;
        if(helperWithMemo(maze, maze.length-1, maze[0].length-1, res, new HashMap<Point, Boolean>()))
            return res;
        return null;
    }

    private boolean helperWithMemo(boolean[][] maze, int row, int col, List<Point> path, Map<Point, Boolean> seen){
        if(row <0|| col < 0 || !maze[row][col]) return false;

        Point p = new Point(row, col);

        if(seen.containsKey(p))return seen.get(p);

        boolean isAtOrigin = row == 0 && col == 0;
        boolean success = false;
        if(isAtOrigin || helperWithMemo(maze, row-1, col, path, seen) || helperWithMemo(maze, row, col-1, path, seen)){
            path.add(p);
            success = true;
        }
        seen.put(p,success);
        return success;
    }


}
