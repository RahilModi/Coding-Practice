package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInEachLevel {

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        bfs.offer(root);
        while(!bfs.isEmpty()){
            int crtMax = Integer.MIN_VALUE;
            for(int i = bfs.size(); i > 0 ; i--){
                root= bfs.poll();
                crtMax = Math.max(crtMax, root.val);
                if(root.left != null) bfs.offer(root.left);
                if(root.right != null) bfs.offer(root.right);
            }
            res.add(crtMax);
        }
        return res;

    }
}
