package com.programming.leetcode.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        Integer root_val=root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            if(root_val != t.val){
                return false;
            }
            if(t.left != null) queue.offer(t.left);
            if(t.right != null) queue.offer(t.right);
        }
        return true;
    }

}
