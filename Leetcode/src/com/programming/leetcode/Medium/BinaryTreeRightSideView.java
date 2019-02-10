package com.programming.leetcode.Medium;

import java.util.*;

//leetcode : 199
//https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView {

    Map<Integer, Integer> vals = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        List<Integer> res = new ArrayList<>();
        for(int d : vals.keySet()){
            res.add(d, vals.get(d));
        }
        return res;
    }

    public void helper(TreeNode node, int depth){
        if(node == null) return;
        if(!vals.containsKey(depth)) vals.put(depth, node.val);
        helper(node.right, depth+1);
        helper(node.left, depth+1);
    }


    public List<Integer> rightSideViewV1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }


    public List<Integer> rightSideViewUsingLevelOrder(TreeNode root) {
        // reverse level traversal
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return result;

        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) result.add(cur.val);
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }

        }
        return result;
    }

}
