package com.programming.leetcode.Easy;

public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //check valid pos..
        boolean ans = rec1[2] <= rec2[0] ||
                      rec1[3] <= rec2[0] ||
                      rec1[0] >= rec2[2] ||
                      rec1[1] >= rec2[1];
        return !ans;
    }

    /***
     * Before we do it in 2D plane, let's try it in 1D.
     * Given 2 segment (left1, right1), (left2, right2), how can we check whether they overlap?
     * If these two intervals overlap, it should exist an number x,
     *                  |---------------------------------|
     *  |------------------------------|
     *  left1          left2           right1             right2
     * left1 < x < right1 && left2 < x < right2
     *
     * left1 < x < right2 && left2 < x < right1
     *
     * left1 < right2 && left2 < right1
     *
     * This is the sufficient and necessary condition for two segments overlap.
     *
     * Explanation:
     * For 2D, if two rectancle overlap both on x and y, they overlap in the plane.
     *
     * Time Complexity:
     * O(1)
      * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlapV1(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }

    public boolean isRectangleOverlapV2(int[] rec1, int[] rec2){
        int left = Math.max(rec1[0], rec2[0]);
        int right = Math.min(rec1[2], rec2[2]);
        int bottom = Math.max(rec1[1], rec2[1]);
        int top = Math.min(rec1[3], rec2[3]);

        return right > left && top > bottom;
    }


}
