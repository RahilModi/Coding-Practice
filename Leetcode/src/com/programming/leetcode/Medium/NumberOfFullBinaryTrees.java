package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfFullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int N) {
        if(N%2==0) return new ArrayList<TreeNode>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        return helper(N, map);
    }

    public List<TreeNode> helper(Integer n, Map<Integer, List<TreeNode>> map){
        if(map.containsKey(n)) return map.get(n);
        List<TreeNode> list = new ArrayList<>();
        if(n == 1){
            TreeNode node = new TreeNode(0);
            list.add(node);
        }else{
            for(int i = 1; i+2 <= n ; i += 2){
                List<TreeNode> left = helper(i, map);
                List<TreeNode> right = helper(n-i-1, map);
                for(TreeNode l : left){
                    for(TreeNode r: right){
                        TreeNode root = new TreeNode(0);
                        root.left = l;
                        root.right = r;
                        list.add(root);
                    }
                }
            }
        }
        map.put(n, list);
        return list;
    }

    public static void main(String[] args) {
        new NumberOfFullBinaryTrees().allPossibleFBT(7);
    }
}
