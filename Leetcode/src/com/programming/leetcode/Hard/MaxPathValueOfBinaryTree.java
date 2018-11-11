package com.programming.leetcode.Hard;

import com.programming.leetcode.Hard.TreeNode;

public class MaxPathValueOfBinaryTree {

    int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathRoot(root);
        return maxVal;
    }

    public int maxPathRoot(TreeNode node){
        if(node== null)return 0 ;
        int left = Math.max(0, maxPathRoot(node.left));
        int right = Math.max(0, maxPathRoot(node.right));
        maxVal = Math.max(maxVal, left+right+node.val);
        return Math.max(left, right)+node.val;
    }

}
