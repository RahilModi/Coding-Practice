package com.programming.leetcode.Hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MazeIII {

    class Point{
        int x, y, dist;
        String path;

        public Point(int x, int y, int dist, String p) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.path = p;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        
        int m = maze.length, n = maze[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        String[] dir = {"r","d","l","u"};
        boolean[][] visited = new boolean[m][n];
        if(ball[0] == hole[0] && ball[1] == hole[1]) return "";
        PriorityQueue<Point> pq = new PriorityQueue<>((p1,p2)->p1.dist == p2.dist? p1.path.compareTo(p2.path) : p1.dist-p2.dist);
        pq.offer(new Point(ball[0],ball[1],0,""));

        while (!pq.isEmpty()){
            Point crtPos = pq.poll();
            if(crtPos.x == hole[0] && crtPos.y == hole[1]) return crtPos.path;
            visited[crtPos.x][crtPos.y] = true;
            for(int k = 0; k < 4; k++){
                int crtDist = crtPos.dist;
                int newR = crtPos.x, newC = crtPos.y;
                while (newR+dirs[k]>= 0 && newC+dirs[k+1] >= 0 && newR+dirs[k] < m && newC+dirs[k+1]< n && maze[newR+dirs[k]][newC+dirs[k+1]] == 0){
                    newR += dirs[k];
                    newC += dirs[k+1];
                    crtDist++;
                    if(newR == hole[0] && newC == hole[1]) {
                        break;
                    }
                }
                if(!visited[newR][newC]){
                    pq.offer(new Point(newR,newC,crtDist,crtPos.path+dir[k]));
                }
            }
        }
        return "impossible";
    }

    //Much faster because not using PriorityQueue.
    public String findShortestWayV1(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        String[] dir = {"r","d","l","u"};
        Point [] [] dp = new Point[m][n];
        Queue<Point> q = new LinkedList<>();
        Point start = new Point(ball[0],ball[1],0,"");
        q.offer(start);
        dp[ball[0]][ball[1]] = start;
        int hx = hole[0], hy = hole[1];
        maze[hx][hy] = -1;
        while(!q.isEmpty())
        {
            Point cur = q.poll();
            int x = cur.x, y = cur.y, dist = cur.dist;
            if(x == hx && y == hy) continue;
            String path = cur.path;
            for(int i = 0; i < 4; i++)
            {
                int dx = dirs[i], dy = dirs[i+1];
                int nx = x, ny = y;
                int d = 0;
                while(nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0)
                {
                    nx += dx;
                    ny += dy;
                    d++;
                }
                if(nx != hx || ny != hy)
                {
                    nx -= dx;
                    ny -= dy;
                    d--;
                }

                Point newN = new Point(nx, ny, dist + d, path+dir[i]);
                if(dp[nx][ny] == null || dp[nx][ny].dist > newN.dist || (dp[nx][ny].dist == newN.dist && dp[nx][ny].path.compareTo(newN.path) > 0))
                {
                    dp[nx][ny] = newN;
                    q.offer(newN);
                }
            }
        }

        return dp[hx][hy] == null ? "impossible" : dp[hx][hy].path;
    }

}
