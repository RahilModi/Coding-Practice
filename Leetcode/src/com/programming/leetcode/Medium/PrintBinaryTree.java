package com.programming.leetcode.Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if(root == null) return res;
        int treeHeight = getHeight(root);
        int numRows = treeHeight, numCols = (1 << treeHeight)-1;
        for(int i = 0; i < numRows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < numCols; j++) {
                row.add("");
            }
            res.add(row);
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<int[]> indexQuue = new ArrayDeque<>();

        queue.offer(root);
        indexQuue.offer(new int[]{0, numCols-1});
        int crtRow = -1;
        while (!queue.isEmpty()){
            crtRow++;
            for(int i = queue.size(); i> 0; i--){
                TreeNode crtNode = queue.poll();
                int[] index = indexQuue.poll();
                int mid = index[0] + (index[1] - index[0])/2;
                res.get(crtRow).set(mid, crtNode.val+"");
                if(crtNode.left != null){
                    queue.add(crtNode.left);
                    indexQuue.add(new int[]{index[0], mid-1});
                }
                if(crtNode.right != null){
                    queue.add(crtNode.right);
                    indexQuue.add(new int[]{mid+1,index[1]});
                }
            }
        }
        return res;
    }

    private int getHeight(TreeNode node){
        if(node == null) return 0;
        return 1 + (Math.max(getHeight(node.left), getHeight(node.right)));
    }
}
