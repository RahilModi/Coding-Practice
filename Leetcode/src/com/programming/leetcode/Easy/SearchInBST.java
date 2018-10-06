package com.programming.leetcode.Easy;

public class SearchInBST {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode temp = root;
        while(temp != null){
            if(temp.val == val) return temp;
            else if(temp.val > val) temp = temp.left;
            else temp = temp.right;
        }

        return null;
    }

    public TreeNode searchBSTV2(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        TreeNode tmp = null;
        if(root.val > val)
            tmp = searchBSTV2(root.left, val);
        else
            tmp = searchBSTV2(root.right, val);

        return tmp;
    }

}
