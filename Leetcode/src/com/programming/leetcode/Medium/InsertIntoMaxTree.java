package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class InsertIntoMaxTree {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root != null && root.val > val){
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
        TreeNode newNode = new TreeNode(val);
        newNode.left = root;
        return newNode;
    }

    public TreeNode insertIntoMaxTreeIterative(TreeNode root, int val) {
        TreeNode node = new TreeNode(val), crt = root;
        if(root.val < val){
            node.left = root;
            return node;
        }
        while (crt.right !=null && crt.right.val > val){
            crt = crt.right;
        }
        node.left = crt.right;
        crt.right = node;
        return root;
    }


}
