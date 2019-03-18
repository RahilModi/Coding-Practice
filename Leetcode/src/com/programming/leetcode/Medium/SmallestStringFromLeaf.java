package com.programming.leetcode.Medium;

public class SmallestStringFromLeaf {
    public String smallestFromLeaf(TreeNode root) {
        return postOrder(root);
    }

    private String postOrder(TreeNode node){
        if(node == null) return "";
        String l = postOrder(node.left);
        String r = postOrder(node.right);
        char crtVal = (char)(node.val + 'a');
        if(!l.isEmpty() && !r.isEmpty()) return (l.compareTo(r) < 0 ? l : r) + crtVal;
        else return (l.isEmpty() ? r : l )+crtVal;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(0);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(1);
        SmallestStringFromLeaf obj = new SmallestStringFromLeaf();
        System.out.println(obj.smallestFromLeaf(node));
    }
}
