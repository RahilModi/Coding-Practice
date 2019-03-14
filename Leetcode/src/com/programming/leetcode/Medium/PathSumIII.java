package com.programming.leetcode.Medium;

public class PathSumIII {

    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return count;
        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right,sum);
        return count;
    }

    public void helper(TreeNode node, int sum){
        if(node == null) return;
        if(node.val == sum) count++;
        helper(node.left, sum-node.val);
        helper(node.right, sum-node.val);
    }
}
