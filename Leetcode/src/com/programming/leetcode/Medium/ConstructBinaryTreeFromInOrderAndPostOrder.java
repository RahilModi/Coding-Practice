package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInOrderAndPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        Map<Integer, Integer> inOrderCache = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inOrderCache.put(inorder[i],i);
        }
        return helper(inorder, postorder, 0, inorder.length-1,0, postorder.length-1, inOrderCache);
    }

    private TreeNode helper(int[] inorder, int[] postOrder, int iS, int iE, int pS, int pE, Map<Integer, Integer> inorderCache){
        if(pS > pE || iS > iE) return null;
        TreeNode root = new TreeNode(postOrder[pE]);
        int crtIdx = inorderCache.get(root.val);
        root.left = helper(inorder, postOrder, iS, crtIdx-1, pS, pS+crtIdx-iS-1, inorderCache);
        root.right = helper(inorder,postOrder, crtIdx+1, iE, pS+crtIdx-iS, pE-1, inorderCache);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInOrderAndPostOrder obj = new ConstructBinaryTreeFromInOrderAndPostOrder();
        System.out.println(obj.buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3}));
    }
}
