package com.programming.leetcode.Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SerializeDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public void serializeHelper(TreeNode node, StringBuilder sb){
        if(node == null) return;
        else{
            sb.append(node.val).append(":");
            serializeHelper(node.left,sb);
            serializeHelper(node.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        return deserializeHelper(new ArrayDeque<String>(Arrays.asList(data.split(":"))));
    }

    public TreeNode deserializeHelper(Queue<String> nodes){
        if(nodes.isEmpty())return null;
        TreeNode crt = new TreeNode(Integer.valueOf(nodes.poll()));
        Queue<String> leftTree = new ArrayDeque<>();
        while (!nodes.isEmpty() && Integer.valueOf(nodes.peek()) < crt.val){
            leftTree.add(nodes.poll());
        }
        crt.left = deserializeHelper(leftTree);
        crt.right = deserializeHelper(nodes);
        return crt;
    }

    public static void main(String[] args) {
        SerializeDeserializeBST obj = new SerializeDeserializeBST();
        obj.deserialize(new StringBuilder().toString());
        obj.deserialize("3:2:1:6:4:8");
    }
}
