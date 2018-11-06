package com.programming.leetcode.Medium;

public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)return new TreeNode(val);
        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }
        else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public TreeNode insertIntoBSTII(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode crt = root;
        while(true){
            if(crt.val < val){
                if(crt.right != null){
                    crt = crt.right;
                }else{
                    crt.right = new TreeNode(val);
                    break;
                }
            }else{
                if(crt.left != null){
                    crt = crt.left;
                }else{
                    crt.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

}
