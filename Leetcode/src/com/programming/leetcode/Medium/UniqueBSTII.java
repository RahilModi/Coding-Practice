package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII {

    public List<TreeNode> generateTrees(int n) {
        if(n < 1) return new ArrayList<>();
        return generate(1,n);
    }

    public List<TreeNode> generate(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        if(start == end){
            res.add(new TreeNode(start));
            return res;
        }

        List<TreeNode> left, right;
        for(int i = start ; i <= end; i++){
            left = generate(start, i-1);
            right = generate(i+1, end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode n = new TreeNode(i);
                    n.left = l;
                    n.right = r;
                    res.add(n);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        UniqueBSTII obj = new UniqueBSTII();
        obj.generateTrees(3);
    }


}
