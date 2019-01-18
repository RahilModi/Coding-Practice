package com.programming.leetcode.Medium;

public class RangeSum {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R);
        return sum;
    }

    public void helper(TreeNode root, int L, int R){
        if(root.val >= L && root.val <= R){
            sum+=root.val;
        }
        if(root.left != null && root.val > L) helper(root.left,L,R);
        if(root.right != null && root.val < R)helper(root.right,L,R);
    }
}
