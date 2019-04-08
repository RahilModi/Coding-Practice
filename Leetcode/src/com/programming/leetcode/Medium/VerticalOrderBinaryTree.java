package com.programming.leetcode.Medium;

import java.util.*;

public class VerticalOrderBinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> obj = new ArrayList<>();
        TreeMap<Integer,PriorityQueue<int[]>> t = new TreeMap<>();
        verticalTraversalHelper(root, t , 0,0);
        List<Integer> lines = new ArrayList<>(t.keySet());
        for(int i : lines){
            PriorityQueue<int[]> q = t.get(i);
            List<Integer> res = new ArrayList<>();
            while (!q.isEmpty()){
                res.add(q.poll()[0]);
            }
            obj.add(res);
        }
        return obj;
    }

    public void verticalTraversalHelper(TreeNode node, TreeMap<Integer, PriorityQueue<int[]>> map, int horizontal_distance, int height){
        if(node == null) return;
//        PriorityQueue<int[]> vertical = map.getOrDefault(horizontal_distance, new PriorityQueue<int[]>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                return a[1]==b[1]?a[0]-b[0] : a[1]-b[1];
//            }
//        }));
//        vertical.add(new int[]{node.val,height});
//        map.put(horizontal_distance, vertical);
        map.computeIfAbsent(horizontal_distance, k-> new PriorityQueue<int[]>((a,b)->a[1]==b[1] ? a[0]-b[0] : a[1]-b[1])).add(new int[]{node.val, height});
        verticalTraversalHelper(node.left, map, horizontal_distance-1, height+1);
        verticalTraversalHelper(node.right, map, horizontal_distance+1, height+1);
    }


}
