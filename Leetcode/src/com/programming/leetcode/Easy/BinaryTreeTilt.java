package com.programming.leetcode.Easy;

public class BinaryTreeTilt {
    int tilt = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return tilt;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        tilt += Math.abs(left-right);
        return root.val+left +right;
    }

}
