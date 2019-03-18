package com.programming.DailyCoding;

import com.programming.leetcode.Easy.TreeNode;

public class Day36 {
    /*
    This problem was asked by Dropbox.
    Given the root to a binary search tree, find the second largest node in the tree.
     */

    class Count{
        int counter;
        int answer;

        public Count(int counter) {
            this.counter = counter;
        }
    }

    private int secondLargestElementInBST(TreeNode root){
        Count obj = new Count(0);
        secondLargestUtil(root, obj);
        return obj.answer;
    }

    private void secondLargestUtil(TreeNode node, Count obj){
        if(node == null || obj.counter > 2) {
            return;
        }
        secondLargestUtil(node.right, obj);
        obj.counter++;
        if(obj.counter == 2){
            obj.answer = node.val;
            return;
        }
        secondLargestUtil(node.left, obj);
    }

}
