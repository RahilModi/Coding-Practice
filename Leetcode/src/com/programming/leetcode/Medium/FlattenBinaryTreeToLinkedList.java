package com.programming.leetcode.Medium;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flattenV1(TreeNode root){
        TreeNode node = root;
        while(node!= null){
            if(node.left!= null){
                TreeNode pre = node.left;
                while(pre.right!=null){
                    pre = pre.right;
                }
                pre.right=node.right;
                node.right = node.left;
                node.left= null;
            }
            node = node.right;
        }
    }

    public void flattenV2(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()){
            TreeNode curr = stk.pop();
            if (curr.right!=null)
                stk.push(curr.right);
            if (curr.left!=null)
                stk.push(curr.left);
            if (!stk.isEmpty())
                curr.right = stk.peek();
            curr.left = null;  // dont forget this!!
        }
    }
}
