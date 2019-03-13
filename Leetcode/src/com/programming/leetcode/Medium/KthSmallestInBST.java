package com.programming.leetcode.Medium;

import java.util.Stack;

public class KthSmallestInBST {

    //Same approach for inorder Traversal ...Validate BST
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) break;
            root = root.right;
        }
        return root.val;
    }
}
