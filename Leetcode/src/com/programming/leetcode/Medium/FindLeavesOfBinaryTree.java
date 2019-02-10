package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLeavesOfBinaryTree {

    Map<Integer, List<Integer>> heightMap = new HashMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int root_height = heightOfTree(root);
        for(int i = 1; i <= root_height; i++){
            res.add(heightMap.get(i));
        }
        return res;
    }

    public int heightOfTree(TreeNode node){
        if(node == null) return 0;
        int leftTreeHeight = heightOfTree(node.left);
        int rightTreeHeight = heightOfTree(node.right);
        int crt_node_height = Math.max(leftTreeHeight,rightTreeHeight)+1;
        heightMap.computeIfAbsent(crt_node_height, k ->new ArrayList<>()).add(node.val);
        return crt_node_height;
    }

}
