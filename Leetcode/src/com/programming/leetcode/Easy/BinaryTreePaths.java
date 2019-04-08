package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        helper(res, new StringBuilder(), root);
        return res;
    }

    private  void helper(List<String> res, StringBuilder sb, TreeNode node){
        sb.append(node.val).append(" ");
        if(node.left == null && node.right == null) {
            res.add(sb.toString().trim().replaceAll(" ", "->"));
            return;
        }
        if(node.left != null) helper(res,sb,node.left);
        if(node.right != null) helper(res,sb,node.right);
    }
}
