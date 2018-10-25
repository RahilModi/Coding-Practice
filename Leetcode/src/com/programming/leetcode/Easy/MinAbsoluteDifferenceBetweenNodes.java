package com.programming.leetcode.Easy;

public class MinAbsoluteDifferenceBetweenNodes {

    Integer minDiff = Integer.MAX_VALUE, prev = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null){
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        }
        prev = root.val;
        inorder(root.right);
    }
}
