package com.programming.leetcode.Easy;

public class ClosestValueInBST {

    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        int closestVal = Integer.MAX_VALUE;
        while(root != null) {
            int crtVal = root.val;
            if(Math.abs(crtVal-target) < Math.abs(closestVal-target)){
                closestVal = crtVal;
            }
            root = root.val > target ? root.left : root.right;
        }
        return closestVal;
    }
}
