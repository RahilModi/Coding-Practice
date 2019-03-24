package com.programming.leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToBinaryTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        return helper(root, null,  v, d, 0);
    }

    private TreeNode helper(TreeNode node, TreeNode parent, int v, int targetDepth, int crtDepth){
        if(targetDepth == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = node;
            return newRoot;
        }
        else if(crtDepth == targetDepth-1){
            if(parent.left == node) {
                TreeNode newNode = new TreeNode(v);
                newNode.left = parent.left;
                parent.left = newNode;
            }else{
                TreeNode newNode = new TreeNode(v);
                newNode.right = parent.right;
                parent.right = newNode;
            }
            return parent;
        }else if(node == null) return null;
        helper(node.left, node, v, targetDepth, crtDepth+1);
        helper(node.right, node, v, targetDepth, crtDepth+1);
        return node;
    }

    public TreeNode addOneRowV1(TreeNode root, int v, int d) {
        if (d < 2) {
            TreeNode newroot = new TreeNode(v);
            if (d == 0) newroot.right = root;
            else newroot.left = root;
            return newroot;
        }
        if (root == null) return null;
        root.left = addOneRowV1(root.left, v, d == 2 ? 1 : d-1);
        root.right = addOneRowV1(root.right, v, d == 2 ? 0 : d-1);
        return root;
    }

    private void dfs(TreeNode root, int depth, int v, int d) {
        if (root == null) return;
        if (depth < d-1) {
            dfs(root.left, depth+1, v, d);
            dfs(root.right, depth+1,v, d);
        } else {
            TreeNode tmp = root.left;
            root.left = new TreeNode(v);
            root.left.left = tmp;
            tmp = root.right;
            root.right = new TreeNode(v);
            root.right.right = tmp;
        }
    }
    //DFS with Helper..
    public TreeNode addOneRowV2(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newroot = new TreeNode(v);
            newroot.left = root;
            return newroot;
        }
        dfs(root, 1, v, d);
        return root;
    }


    //Using BFS
    public TreeNode addOneRowV3(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newroot = new TreeNode(v);
            newroot.left = root;
            return newroot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 0; i < d-2; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode t = queue.poll();
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
            }
        }
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            TreeNode tmp = t.left;
            t.left = new TreeNode(v);
            t.left.left = tmp;
            tmp = t.right;
            t.right = new TreeNode(v);
            t.right.right = tmp;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2); root.left = node1;
        TreeNode node2 = new TreeNode(3); node1.right = node2;
        TreeNode node3 = new TreeNode(4); node2.right = node3;
        TreeNode node4 = new TreeNode(1); node1.left = node4;
        TreeNode node5 = new TreeNode(7); root.right= node5;
        TreeNode node6 = new TreeNode(6);node5.left = node6;
        TreeNode node7 = new TreeNode(8); node5.right = node7;
        AddOneRowToBinaryTree obj = new AddOneRowToBinaryTree();
        System.out.println(obj.addOneRow(root, 10, 2));

    }
}
