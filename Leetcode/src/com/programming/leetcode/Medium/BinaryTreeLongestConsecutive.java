package com.programming.leetcode.Medium;

public class BinaryTreeLongestConsecutive {

    int maxLength = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, 1, root.val+1);
        return maxLength;
    }

    public void helper(TreeNode node, int length, int lookupVal){
        if(node == null) return;
        if(node.left == null && node.right == null){
            maxLength = Math.max(maxLength, length);
            return;
        }
        maxLength = Math.max(maxLength, length);
        if(node.left != null){
            if(node.left.val == lookupVal){
                helper(node.left, length+1, lookupVal+1);
            }else{
                helper(node.left, 1, node.left.val+1);
            }
        }
        if(node.right != null){
            if(node.right.val == lookupVal){
                helper(node.right, length+1, lookupVal+1);
            }else{
                helper(node.right, 1, node.right.val+1);
            }
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        BinaryTreeLongestConsecutive obj = new BinaryTreeLongestConsecutive();
        System.out.println(obj.longestConsecutive(root));
    }
}
