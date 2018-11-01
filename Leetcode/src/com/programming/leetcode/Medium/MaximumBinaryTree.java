package com.programming.leetcode.Medium;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length ; i++){
            TreeNode crtNode = new TreeNode(nums[i]);

            while(!stack.isEmpty() && stack.peek().val < nums[i]){
                crtNode.left = stack.pop();
            }
            if(!stack.isEmpty()){
                stack.peek().right = crtNode;
            }
            stack.push(crtNode);
        }

        return stack.isEmpty() ? null : stack.removeLast();

    }

    public TreeNode constructMaximumBinaryTreeUsingRecursion(int[] nums) {
        if(nums==null|| nums.length ==0) return null;
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int start, int end){
        if(start > end) return null;
        int maxPos = maxPosElement(nums, start, end);
        TreeNode root = new TreeNode(nums[maxPos]);
        root.left = helper(nums, start, maxPos-1);
        root.right = helper(nums, maxPos+1, end);
        return root;
    }

    private int maxPosElement(int [] nums, int start, int end){
        int max_val = nums[start];
        int index = start;
        for(int i = start+1; i <= end; i++) {
            if(nums[i] > max_val) {
                index = i;
                max_val = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        new MaximumBinaryTree().constructMaximumBinaryTreeUsingRecursion(new int[]{3,2,1,6,0,5});
    }
}
