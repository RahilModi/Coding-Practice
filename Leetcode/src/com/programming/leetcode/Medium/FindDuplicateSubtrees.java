package com.programming.leetcode.Medium;

import java.util.*;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        helper(root, new HashMap<>(), res);
        return res;
    }

    private String helper(TreeNode node, Map<String, Integer> map, List<TreeNode> res){
        if(node == null) return  "#";
        String crt = node.val + "," + helper(node.left, map, res) + "," + helper(node.right, map, res);
        if(map.getOrDefault(crt, 0) ==1) res.add(node);
        map.put(crt, map.getOrDefault(crt,0)+1);
        return crt;
    }

}
