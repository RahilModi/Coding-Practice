package com.programming.leetcode.Medium;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = treeHeight(root, true);
        int rightHeight = treeHeight(root, false);
        if(rightHeight == leftHeight){
            return (2<<(leftHeight-1)) - 1;  //2^h -1 for number of complete nodes
        }else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }

    private int treeHeight(TreeNode root, boolean isLeft){
        int height = 0;
        while(root != null){
            if(isLeft)
                root = root.left;
            else
                root = root.right;
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);
        rootNode.left.left = new TreeNode(4);
        rootNode.left.right = new TreeNode(5);
        rootNode.right.left = new TreeNode(6);

        System.out.println(new CountCompleteTreeNodes().countNodes(rootNode));

    }

}


