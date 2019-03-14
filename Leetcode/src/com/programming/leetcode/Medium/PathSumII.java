package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, res, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode node, int sum, List<List<Integer>> res, List<Integer> crt){
        if(node == null) return;
        if(node.left== null && node.right == null){
            if(sum == node.val){
                crt.add(node.val);
                res.add(new ArrayList<>(crt));
                crt.remove(crt.size()-1);
                return;
            }
        }
        crt.add(node.val);
        helper(node.left, sum-node.val, res,crt);
        helper(node.right, sum-node.val, res,crt);
        crt.remove(crt.size()-1);
    }

}
