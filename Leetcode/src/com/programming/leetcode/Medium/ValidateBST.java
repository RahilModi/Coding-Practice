package com.programming.leetcode.Medium;

import java.util.Stack;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    //methiod2 better prformance and clean code
    public boolean isValidBSTWithBound(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return isValidWithBound(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidWithBound(TreeNode root, double low, double high){
        if(root == null) return true;
        if(root.val <= low || root.val >= high) return false;
        return isValidWithBound(root.left, low, root.val) && isValidWithBound(root.right, root.val, high);
    }
}
