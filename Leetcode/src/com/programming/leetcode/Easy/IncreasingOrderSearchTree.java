package com.programming.leetcode.Easy;

public class IncreasingOrderSearchTree {

    TreeNode prev = null, newHead = null;

    public TreeNode increasingBST(TreeNode root) {

        //TreeNode newRoot = dfsOnBST(root, null);

        return helper(root);

    }

    private TreeNode dfsOnBST(TreeNode root, TreeNode temp){

        if(root == null) return temp;

        TreeNode res = dfsOnBST(root.left, root);

        root.left = null;

        root.right = dfsOnBST(root.right, temp);

        return res;
    }


    private TreeNode helper(TreeNode root){
        if(root == null) return null;

        helper(root.left);

        if(prev != null){
            root.left = null;
            prev.right = root;
        }

        if(newHead == null) newHead = root;
        prev = root;

        helper(root.right);

        return newHead;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left =new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        TreeNode res = new IncreasingOrderSearchTree().increasingBST(root);
        System.out.println(res.val+", "+res.right.val+", "+res.right.right.val+", "+res.right.right.right.val+", "+res.right.right.right.right.val);
    }



}
