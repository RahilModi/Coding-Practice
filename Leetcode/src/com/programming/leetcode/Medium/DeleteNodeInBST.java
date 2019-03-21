package com.programming.leetcode.Medium;

public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return root;
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root){
        while (root.left!=null) root = root.left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.right = new TreeNode(7);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(8);
        node.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.left.left = new TreeNode(2);
        DeleteNodeInBST obj = new DeleteNodeInBST();
        System.out.println(obj.deleteNode(node,3));
    }
}
