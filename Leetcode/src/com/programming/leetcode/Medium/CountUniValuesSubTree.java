package com.programming.leetcode.Medium;

public class CountUniValuesSubTree {

    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        univalSubtreesHelper(root);
        return count;
    }

    public boolean univalSubtreesHelper(TreeNode node) {
        if(node== null){
            return true;
        }
        if(node.left == null && node.right == null ){
            count++;
            return true;
        }
        boolean leftTree = univalSubtreesHelper(node.left);
        boolean rightTree = univalSubtreesHelper(node.right);
        if(leftTree == rightTree){
            if(node.left == null){
                if(node.right.val == node.val) {
                    count++;
                    return true;
                }
            }else if(node.right == null){
                if(node.left.val == node.val) {
                    count++;
                    return true;
                }
            }else {
                if(node.val == node.left.val && node.val == node.right.val){
                    count++;
                    return true;
                }
            }
        }
        return false;
    }

}
