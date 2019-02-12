package com.programming.leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class EqualTreePartition {

    Set<Integer> sumsSet = new HashSet<>();
    public boolean checkEqualTree(TreeNode root) {
        int finalSum = root.val + sumOfTree(root.left) + sumOfTree(root.right);
        if((finalSum & 1)==1) return false;
        return sumsSet.contains(finalSum>>1);
    }

    public int sumOfTree(TreeNode node){
        if(node == null) return 0;
        int sum = node.val + sumOfTree(node.left) + sumOfTree(node.right);
        sumsSet.add(sum);
        return sum;
    }

    public static void main(String[] args) {
        EqualTreePartition obj = new EqualTreePartition();
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(-1);
        treeNode.right = new TreeNode(1);
        System.out.println(obj.checkEqualTree(treeNode));
    }
}
