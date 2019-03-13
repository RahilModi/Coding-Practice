package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        List<Integer> level = null;
        while(!s1.isEmpty() || !s2.isEmpty()){
            level = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode crt = s1.pop();
                level.add(crt.val);
                if(crt.left != null) s2.push(crt.left);
                if(crt.right != null) s2.push(crt.right);
            }
            if(level.size() != 0){
                res.add(new ArrayList<>(level));
            }
            level = new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode crt = s2.pop();
                level.add(crt.val);
                if(crt.right != null) s1.push(crt.right);
                if(crt.left != null) s1.push(crt.left);
            }
            if(level.size() != 0){
                res.add(new ArrayList<>(level));
            }
        }
        return res;

    }
}
