package com.programming.leetcode.Medium;


public class RecoverBST {

    TreeNode firstElem = null, secondElem = null, prevElem = new TreeNode(Integer.MIN_VALUE);
    //Another solution is using morris traversal...
    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);
        int temp = firstElem.val;
        firstElem.val = secondElem.val;
        secondElem.val = temp;
    }

    public void inOrderTraversal(TreeNode node){
        if(node == null) return;
        inOrderTraversal(node.left);
        if(firstElem == null && prevElem.val >= node.val){
            firstElem = prevElem;
        }
        if(firstElem != null && prevElem.val >= node.val){
            secondElem = node;
        }
        prevElem = node;
        inOrderTraversal(node.right);
    }
}
