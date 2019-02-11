package com.programming.leetcode.Medium;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        if(root == null)return;
        TreeNode crt = root;
        while(crt != null){
            stack.push(crt);
            crt = crt.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode val = stack.pop();
        if(val.right != null){
            TreeNode crt = val.right;
            while(crt != null){
                stack.push(crt);
                crt = crt.left;
            }
        }
        return val.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
