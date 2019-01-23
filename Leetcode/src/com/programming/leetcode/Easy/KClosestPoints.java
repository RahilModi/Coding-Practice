package com.programming.leetcode.Easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints {

    class Point{
        int x, y;
        int distToOrigin;

        public Point(int x, int y, int distToOrigin) {
            this.x = x;
            this.y = y;
            this.distToOrigin = distToOrigin;
        }
    }


    private Integer distanceFromOrigin(int[] point){
        return (int) (point[0]*point[0] + point[1]*point[1]);
    }

    PriorityQueue<Point> pq = new PriorityQueue<>((p1,p2)->p2.distToOrigin-p1.distToOrigin);

    public int[][] kClosest(int[][] points, int K) {

        for(int[] point :points){
            Integer sqred_dist = distanceFromOrigin(point);
            Point p = new Point(point[0],point[1],sqred_dist);
            pq.offer(p);
            if(pq.size() > K) pq.poll();
        }

        int[][] res = new int[K][2];
        Point t;
        while(K-->0){
            t = pq.poll();
            res[K][0] = t.x;
            res[K][1] = t.y;
        }

        return res;

    }

    /***
     * Quick Select An Efficient Searching for K Elements
     * Not stable and not sorted K elements but very efficient
     * @param points
     * @param K
     * @return
     */


    public int[][] kClosestQuickSelect(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

    public static void main(String[] args) {
        KClosestPoints obj = new KClosestPoints();
        obj.kClosestQuickSelect(new int[][]{{1,3},{-2,2}},1);
    }


}
