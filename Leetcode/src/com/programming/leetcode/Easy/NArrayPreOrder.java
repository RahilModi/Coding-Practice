package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NArrayPreOrder {

    static class Node {
        public int val;
        public List<NArrayPreOrder.Node> children;

        public Node() {}

        public Node(int _val,List<NArrayPreOrder.Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {

        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node n = stack.pop();
            result.add(n.val);
            int childrenSize = n.children.size();
            for(int i = childrenSize-1 ; i >= 0; i-- ){
                stack.push(n.children.get(i));
            }
        }

        return result;
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderV2(Node root) {

        if(root == null) return res;

        res.add(root.val);
        for(Node n: root.children){
            preorderV2(n);
        }

        return res;
    }

    public List<Integer> preorderV3(Node root){
        return travarsalHelper(root, new ArrayList<>());
    }

    private List<Integer> travarsalHelper(Node root, List<Integer> res){
        if(root == null) return res;

        res.add(root.val);
        for(Node n : root.children){
            travarsalHelper(n, res);
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

        for(int i : new NArrayPreOrder().preorder(n)){
            System.out.print(i+", ");
        }
        System.out.println();

        for(int i : new NArrayPreOrder().preorderV2(n)){
            System.out.print(i+", ");
        }
        System.out.println();

        for(int i : new NArrayPreOrder().preorderV3(n)){
            System.out.print(i+", ");
        }
        System.out.println();
    }

}
