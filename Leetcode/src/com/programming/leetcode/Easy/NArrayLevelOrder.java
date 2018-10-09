package com.programming.leetcode.Easy;


import java.util.*;

public class NArrayLevelOrder {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> temp = new LinkedList<>();
        temp.offer(root);
        while (!temp.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int tempSize = temp.size();
            while (tempSize > 0) {
                Node n = temp.poll();
                for (Node child : n.children) {
                    temp.offer(child);
                }
                level.add(n.val);
                tempSize--;
            }
            res.add(level);
        }
        return res;
    }

    public List<List<Integer>> levelOrderV2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> temp = new LinkedList<>();
        temp.offer(root);
        temp.offer(null);
        while (!temp.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Node lastpolled = temp.poll();
            while (lastpolled != null) {
                for (Node child : lastpolled.children) {
                    temp.offer(child);
                }
                level.add(lastpolled.val);
                lastpolled = temp.poll();
            }
            if (!temp.isEmpty()) {
                temp.offer(null);
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        Node n = new Node();
        n.val = 1;
        List<Node> childrens = new ArrayList<>();
        Node n1 = new Node();
        n1.val = 3;
        Node n2 = new Node();
        n2.val = 2;
        Node n3 = new Node();
        n3.val = 4;
        Node n4 = new Node();
        n4.val = 5;
        Node n5 = new Node();
        n5.val = 6;
        childrens.add(n1);
        childrens.add(n2);
        childrens.add(n3);

        List<Node> childrens1 = new ArrayList<>();
        childrens1.add(n4);
        List<Node> childrens2 = new ArrayList<>();
        childrens2.add(n5);

        n1.children = childrens1;
        n2.children = childrens2;

        n.children = childrens;
        n3.children = new ArrayList<>();
        n4.children = new ArrayList<>();
        n5.children = new ArrayList<>();

        List<List<Integer>> result = new NArrayLevelOrder().levelOrderV2(n);
        for (List<Integer> res : result) {
            for (Integer r : res) {
                System.out.println(r);
            }
        }
    }

}
