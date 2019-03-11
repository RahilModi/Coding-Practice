package com.programming.leetcode.Medium;

import java.util.Stack;

public class ConstructBSTFromPreOrder {

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for(int i = 1; i<preorder.length; i++){
            TreeNode crt = stack.peek();
            if(preorder[i] < crt.val){
                crt.left = new TreeNode(preorder[i]);
                stack.push(crt.left);
            }else if(preorder[i] > crt.val){
                while(!stack.isEmpty() && stack.peek().val < preorder[i]){
                    crt = stack.pop();
                }
                crt.right = new TreeNode(preorder[i]);
                stack.push(crt.right);
            }
        }
        return root;
    }

    int i = 0;
    public TreeNode bstFromPreorderV1(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }

    public static void main(String[] args) {
        ConstructBSTFromPreOrder obj = new ConstructBSTFromPreOrder();
        System.out.println(obj.bstFromPreorder(new int[]{8,3,4,5,6}));
    }

}
