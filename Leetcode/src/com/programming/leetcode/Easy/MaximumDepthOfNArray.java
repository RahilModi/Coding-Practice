package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

public class MaximumDepthOfNArray {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public int maxDepth(Node root) {
        return height(root);
    }

    int prev_max_height = 0;

    private int height(Node root){
        if(root==null) return 0;

        int max =0;
        for(Node n : root.children){
            int depth = height(n);
            if(depth > max){
                max = depth;
            }
        }

        return max + 1;

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

        System.out.println(new MaximumDepthOfNArray().maxDepth(n));


    }
}
