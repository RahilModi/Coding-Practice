package com.programming.leetcode.Medium;

public class RectangleArea {

    boolean isRectangleOverlapV1(int[] rec1, int[] rec2, int[] overlap) {
        boolean bResult;
        bResult = rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
        if (bResult) {
            overlap[0] = Math.max(rec1[0], rec2[0]);
            overlap[1] = Math.min(rec1[2], rec2[2]);
            overlap[2] = Math.max(rec1[1], rec2[1]);
            overlap[3] = Math.min(rec1[3], rec2[3]);
        }
        return bResult;
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = Math.abs(A-C) * Math.abs(B-D);
        int area2 = Math.abs(E-G) * Math.abs(F-H);
        int commonArea = 0;
        int[] commonPoints;
        if(isRectangleOverlapV1(new int[]{A,B,C,D}, new int[]{E,F,G,H},commonPoints = new int[4])){
            commonArea = Math.abs(commonPoints[0]-commonPoints[1]) * Math.abs(commonPoints[2]-commonPoints[3]);
        }
        return area1 + area2 - commonArea;
    }

    public static void main(String[] args) {
        RectangleArea obj = new RectangleArea();
        System.out.println(obj.computeArea(-3,0,3,4,0,-1,9,2));
    }
}
