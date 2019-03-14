package com.programming.leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        int[] r = new int[2];
        helper(root, 1, r);
        return r[0];
    }

    private void helper(TreeNode node, int crtDepth, int[] res){
        if(res[1] < crtDepth) {res[0] = node.val; res[1] = crtDepth;}
        if(node.left != null) helper(node.left, crtDepth+1, res);
        if(node.right != null) helper(node.right, crtDepth+1, res);
    }

    public int findBottomLeftValueV1(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while (!bfs.isEmpty()){
            root = bfs.poll();
            if(root.right!=null){
                bfs.offer(root.right);
            }
            if(root.left != null) {
                bfs.offer(root.left);
            }
        }
        return root.val;
    }
}
