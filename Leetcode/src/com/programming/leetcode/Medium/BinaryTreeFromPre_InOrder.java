package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPre_InOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderCache = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            inOrderCache.put(inorder[i],i);
        }

        return helper(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1, inOrderCache);
    }

    private TreeNode helper(int[] inorder, int inStart,int inEnd, int[] preorder, int preStart, int preEnd, Map<Integer, Integer> inCache){
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inOrderPos =  inCache.get(root.val);
        int numsLeft = inOrderPos - inStart;
        root.left = helper(inorder, inStart,inOrderPos - 1, preorder,preStart+1,preStart+numsLeft,inCache);
        root.right = helper(inorder, inOrderPos+1, inEnd, preorder, preStart+numsLeft+1, preEnd,inCache);

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new BinaryTreeFromPre_InOrder().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        System.out.println();
    }

}
