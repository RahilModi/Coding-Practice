package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode crt = root;
        while(crt != null){
            if(crt.left == null){
                res.add(crt.val);
                crt = crt.right;
            }else{
                TreeNode predecessor = crt.left;
                while(predecessor.right != crt && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = crt;
                    crt = crt.left;
                }else{
                    predecessor.right = null;
                    res.add(crt.val);
                    crt = crt.right;
                }
            }
        }
        return res;
    }
}
