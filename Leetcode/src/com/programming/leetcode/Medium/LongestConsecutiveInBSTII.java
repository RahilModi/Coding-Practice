package com.programming.leetcode.Medium;

public class LongestConsecutiveInBSTII {

    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        int[] res = longestPath(root);
        return maxLen;
    }

    public int[] longestPath(TreeNode node){
        if(node == null) return new int[]{0,0};
        int incr,decr;
        incr = decr = 1;
        if(node.left != null){
            int left[] = longestPath(node.left);
            if(node.val == node.left.val+1){
                decr = left[1]+1;
            }else if(node.val == node.left.val-1){
                incr = left[0]+1;
            }
        }
        if(node.right != null){
            int right[] = longestPath(node.right);
            if(node.val == node.right.val+1){
                decr = Math.max(decr, right[1]+1);
            }else if(node.val == node.right.val-1){
                incr = Math.max(incr, right[0]+1);
            }
        }
        maxLen = Math.max(maxLen, decr+incr-1);
        return new int[]{incr, decr};
    }
}
