package com.programming.leetcode.Medium;
import com.programming.leetcode.Easy.NArrayLevelOrder;

import java.util.*;
import java.util.stream.Collectors;

public class SerializeDeserializeNArrayTree {

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

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<Integer> res = new ArrayList<>();
        serializerHelper(root, res);
        return String.join(",",res.stream().map(String::valueOf).collect(Collectors.toList()));
    }

    public void serializerHelper(Node node, List<Integer> res){
        if (node == null) return;
        else{
            res.add(node.val);
            res.add(node.children.size());
            for(Node c : node.children){
                serializerHelper(c, res);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null || data.isEmpty()) return null;
        Queue<String> list = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserializeHelper(list);
    }

    public Node deserializeHelper(Queue<String> res){
        Node n = new Node();
        n.val = Integer.valueOf(res.poll());
        int size = Integer.valueOf(res.poll());
        n.children = new ArrayList<>();
        for(int i = 0; i < size; i++){
            n.children.add(deserializeHelper(res));
        }
        return n;
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

        SerializeDeserializeNArrayTree obj = new SerializeDeserializeNArrayTree();
        obj.deserialize(obj.serialize(n));
    }
}
