package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class CBTInserter {

    List<TreeNode> tree;
    public CBTInserter(TreeNode root) {
        tree = new ArrayList<>();
        tree.add(root);
        for(int i = 0; i < tree.size(); i++){
            if(tree.get(i).left != null) tree.add(tree.get(i).left);
            if(tree.get(i).right != null) tree.add(tree.get(i).right);
        }
    }

    public int insert(int v) {
        int N = tree.size();
        TreeNode newNode = new TreeNode(v);
        tree.add(newNode);
        if(N%2 == 0)
            tree.get((N-1)/2).right = newNode;
        else
            tree.get((N-1)/2).left = newNode;
        return tree.get((N-1)/2).val;
    }

    public TreeNode get_root() {
        return tree.get(0);
    }
}
