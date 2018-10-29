package com.programming.leetcode.Medium;

import java.util.*;

public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right !=null) return root;
        return left!=null ? left : right;
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q){
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        parents.put(root, null);
        stack.push(root);
        while(!parents.containsKey(p) || !parents.containsKey(q)){
            TreeNode temp = stack.pop();
            if(temp.left != null){
                parents.put(temp.left, temp);
                stack.push(temp.left);
            }
            if(temp.right != null){
                parents.put(temp.right, temp);
                stack.push(temp.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p!=null){
            ancestors.add(p);
            p = parents.get(p);
        }
        while(!ancestors.contains(q)){
            q = parents.get(q);
        }

        return q;



    }

}
