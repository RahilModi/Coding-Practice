package com.programming.leetcode.Easy;

import java.util.LinkedList;
import java.util.List;


public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> LinkedList1 = new LinkedList<>();
        leafHelper(root1, LinkedList1);
        List<Integer> LinkedList2 = new LinkedList<>();
        leafHelper(root2, LinkedList2);
        if(LinkedList1.size() != LinkedList2.size()) return false;
        for(int i = 0 ; i< LinkedList1.size() ; i++){
            if(LinkedList1.get(i) != LinkedList2.get(i)) return false;
        }
        return true;
    }

    private void leafHelper(TreeNode root, List<Integer> leafs){
        if(root.left == null && root.right == null){
            leafs.add(root.val);
            return;
        }
        if(root.left != null) leafHelper(root.left, leafs);
        if(root.right != null) leafHelper(root.right,leafs);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right= new TreeNode(4);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(9);
        root1.right.right= new TreeNode(8);


        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right = new TreeNode(1);
        root2.right.left = new TreeNode(4);
        root2.right.right= new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        new LeafSimilarTrees().leafSimilar(root1,root2);
    }

}
