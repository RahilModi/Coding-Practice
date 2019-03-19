package com.programming.leetcode.Medium;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class SubtreeWithAllDeepestNodes {


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode , Integer> res = new HashMap<>();
        depth(root, res, 0);
        int maxDepth = 0;
        for(int i : res.values()){
            maxDepth = Math.max(maxDepth, i);
        }
        return subtreeWithAllDeepestNodes(root,maxDepth,res);
    }

    private void depth(TreeNode node, Map<TreeNode, Integer> map, int crtDepth){
        if(node == null) return;
        map.put(node,crtDepth);
        depth(node.left,map, crtDepth+1);
        depth(node.right,map, crtDepth+1);
    }

    private TreeNode subtreeWithAllDeepestNodes(TreeNode root, int max, Map<TreeNode, Integer> map){
        if(root ==null || map.get(root) == max) return root;
        TreeNode left = subtreeWithAllDeepestNodes(root.left, max, map);
        TreeNode right = subtreeWithAllDeepestNodes(root.right, max, map);
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.left.right.left =new TreeNode(7);
        node.left.right.right = new TreeNode(8);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(4);
        SubtreeWithAllDeepestNodes obj = new SubtreeWithAllDeepestNodes();
        System.out.println(obj.subtreeWithAllDeepest(node));
    }


}
