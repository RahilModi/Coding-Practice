package com.programming.leetcode.Medium;

public class FlipEquivalent {

    //O(N^2)
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if(root1 == null || root2 == null) return root1 == root2;
        if(root1.val != root2.val) return false;
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right,root2.right)) || (flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left));

    }

    //O(N)
    public boolean flipEquivV1(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null) return root1 == root2;
        if(root1.val != root2.val) return false;

        int left1 = root1.left!=null ? root1.left.val : 0;
        int left2 = root2.left!=null ? root2.left.val : 0;

        if(left1 != left2){
            TreeNode temp = root1.left;
            root1.left = root1.right;
            root1.right = temp;
        }

        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);


    }

}
