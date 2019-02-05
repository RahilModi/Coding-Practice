package com.programming.leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthofBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        int maxwidth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
            q.add(root);
            c.offer(0);
            while (!q.isEmpty()) {
                int size = q.size(), left = 0, right = 0;
                for(int i = 0; i < size; i++){
                    TreeNode temp = q.poll();
                    int index = c.poll();
                    if(i==0)left = index;
                    if(i == size-1)right= index;
                    if (temp.left != null) {
                        q.add(temp.left);
                        c.add(index*2);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                        c.add(index*2+1);
                    }
                }
                maxwidth = Math.max(maxwidth,right - left + 1);
            }
        return maxwidth;
    }
}
