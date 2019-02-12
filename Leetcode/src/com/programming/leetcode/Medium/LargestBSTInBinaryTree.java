package com.programming.leetcode.Medium;

public class LargestBSTInBinaryTree {

    static class Props{
        int minVal;
        int maxVal;
        int size;
        boolean isBST;

        public Props() {
            this.isBST = true;
            this.size = 0;
            this.minVal = Integer.MAX_VALUE;
            this.maxVal = Integer.MIN_VALUE;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        return postOrderTraversal(root).size;
    }

    public Props postOrderTraversal(TreeNode node){
        if(node == null) return new Props();
        Props leftSide = postOrderTraversal(node.left);
        Props rightSide = postOrderTraversal(node.right);

        Props crt = new Props();
        if( leftSide.isBST == false || rightSide.isBST == false || leftSide.maxVal >= node.val || rightSide.minVal <= node.val){
            crt.isBST = false;
            crt.size = Math.max(leftSide.size, rightSide.size);
            return crt;
        }
        crt.minVal = node.left != null ? leftSide.minVal : node.val;
        crt.maxVal = node.right != null ? rightSide.maxVal : node.val;
        crt.size = leftSide.size + rightSide.size +1;
        return crt;
    }
}
