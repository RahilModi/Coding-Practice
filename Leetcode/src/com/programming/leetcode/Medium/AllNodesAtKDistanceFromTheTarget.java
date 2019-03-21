package com.programming.leetcode.Medium;

import java.util.*;

public class AllNodesAtKDistanceFromTheTarget {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty()){
            if(K == 0){
                while (!queue.isEmpty())
                    res.add(queue.poll().val);
                break;
            }
            for(int i = queue.size(); i > 0; i--){
                TreeNode crt = queue.poll();
                if(graph.containsKey(crt)) {
                    for (TreeNode next : graph.get(crt)) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            --K;
        }
        return res;
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph){
        if(node == null) return;
        if (parent != null) {
            graph.computeIfAbsent(node, k -> new ArrayList<>()).add(parent);
            graph.computeIfAbsent(parent, k -> new ArrayList<>()).add(node);
        }
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }



    public List<Integer> distanceKV1(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, Integer> map = new HashMap<>();
        helper(root, target, map);
        List<Integer> res= new ArrayList<>();
        findAlltheNodesAtDistanceK(root, 0, K,map,res);
        return res;
    }

    private int helper(TreeNode node, TreeNode target, Map<TreeNode, Integer> distMap){
        if(node == null) return -1;
        if(node.val == target.val){
            distMap.put(node, 0);
            return 0;
        }

        int left = helper(node.left, target, distMap);
        if(left != -1){
            distMap.put(node, left+1);
            return left+1;
        }
        int right = helper(node.right, target, distMap);
        if(right == -1) return -1;
        else distMap.put(node, right+1);
        return right+1;
    }

    private void findAlltheNodesAtDistanceK(TreeNode node, int dist, int K, Map<TreeNode, Integer> map, List<Integer> res){
        if(node == null) return;
        if(map.get(node)!=null)dist = map.get(node);
        if(dist ==K) res.add(node.val);
        findAlltheNodesAtDistanceK(node.left, dist+1, K, map, res);
        findAlltheNodesAtDistanceK(node.right, dist+1, K, map, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5); root.left = node1;
        TreeNode node2 = new TreeNode(2); node1.right = node2;
        TreeNode node3 = new TreeNode(4); node2.right = node3;
        TreeNode node9 = new TreeNode(7); node2.left = node9;
        TreeNode node4 = new TreeNode(6); node1.left = node4;
        TreeNode node5 = new TreeNode(1); root.right= node5;
        TreeNode node6 = new TreeNode(0);node5.left = node6;
        TreeNode node7 = new TreeNode(8); node5.right = node7;

        AllNodesAtKDistanceFromTheTarget obj = new AllNodesAtKDistanceFromTheTarget();
        System.out.println(obj.distanceK(root, node1,2));
        System.out.println(obj.distanceKV1(root, node1,2));

    }

}
