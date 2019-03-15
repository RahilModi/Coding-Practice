package com.programming.leetcode.Medium;

public class DistributeCoinsInBinaryTree {
    public int distributeCoins(TreeNode root) {
        return dfs(root, new int[1]);
    }

    private int dfs(TreeNode node, int[] res){
        if(node == null) return 0;
        int left = dfs(node.left,res);
        int right = dfs(node.right,res);
        res[0] += Math.abs(left) + Math.abs(right);
        return node.val + left + right -1;
    }
}
