package com.programming.leetcode.Hard;

public class BinaryTreeCamera {

    //https://leetcode.com/problems/binary-tree-cameras/discuss/211180/JavaC%2B%2BPython-Greedy-DFS
    public int minCameraCover(TreeNode root) {
        int[] res = new int[1];
        return (helper(root, res) < 1 ? 1 : 0)+ res[0];
    }

    public int helper(TreeNode node, int[] res){
        if(node ==null) return 2;
        int left = helper(node.left,res);
        int right = helper(node.left,res);
        if(left == 0 && right == 0){
            res[0]++;
            return 1;
        }
        return (left == 1 || right == 1) ? 2 : 0;
    }

}
