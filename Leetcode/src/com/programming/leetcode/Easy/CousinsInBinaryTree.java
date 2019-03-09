package com.programming.leetcode.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> res = new LinkedList<>();
        res.offer(root);
        while (!res.isEmpty()){
            int size = res.size();
            boolean isXPresent=false;
            boolean isYPresent = false;
            for(int i = 0; i < size; i++){
                TreeNode crt = res.poll();
                if(crt.val == x) isXPresent = true;
                if(crt.val == y) isYPresent = true;
                if(crt.left != null && crt.right != null){
                    if((crt.left.val == x && crt.right.val == y ) || (crt.left.val == y && crt.right.val == x)){
                        return false;
                    }
                }
                if(crt.left != null){
                    res.offer(crt.left);
                }
                if(crt.right != null){
                    res.offer(crt.right);
                }
            }
            if(isXPresent && isYPresent){
                return true;
            }
        }
        return false;
    }

}
