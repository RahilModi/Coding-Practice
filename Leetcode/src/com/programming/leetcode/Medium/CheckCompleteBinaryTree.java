package com.programming.leetcode.Medium;

import java.util.*;

public class CheckCompleteBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);
        boolean end =false;
        while (!levelQueue.isEmpty()){
            TreeNode temp = levelQueue.poll();
            if(temp != null) {
                if(end) return false;
                else{
                    levelQueue.offer(temp.left);
                    levelQueue.offer(temp.right);
                }
            }else {
                end = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);
        rootNode.left.left = new TreeNode(4);
        rootNode.right.left = new TreeNode(6);

        System.out.println(new CheckCompleteBinaryTree().isCompleteTree(rootNode));
    }

}
