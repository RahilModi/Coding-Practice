package com.programming.leetcode.Easy;

public class MinDistanceInBSTNode {

    Integer minDist = Integer.MAX_VALUE, prev = null;
    public int minDiffInBST(TreeNode root) {

        if(root.left != null) minDiffInBST(root.left);
        if(prev != null){
            minDist = Math.min(minDist, root.val-prev);
        }
        prev = root.val;
        if(root.right != null) minDiffInBST(root.right);
        return minDist;
    }
}
