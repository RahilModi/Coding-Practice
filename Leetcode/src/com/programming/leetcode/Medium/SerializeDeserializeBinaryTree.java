package com.programming.leetcode.Medium;

import java.util.*;

public class SerializeDeserializeBinaryTree {

    private static final String forNullValues = "#";
    private static final String splitter = ":";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializerHelper(root, sb);
        return sb.toString();
    }

    private void serializerHelper(TreeNode node, StringBuilder sb){
        if(node == null)
            sb.append(forNullValues).append(splitter);
        else {
            sb.append(node.val).append(splitter);
            serializerHelper(node.left, sb);
            serializerHelper(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(splitter)));
        TreeNode res = deserializerHelper(nodes);
        return res;
    }

    public TreeNode deserializerHelper(Queue<String> nodes){
        String crtVal = nodes.poll();
        if(crtVal.equals(forNullValues)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(crtVal));
        node.left = deserializerHelper(nodes);
        node.right = deserializerHelper(nodes);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeDeserializeBinaryTree obj = new SerializeDeserializeBinaryTree();
        obj.deserialize(obj.serialize(root));
    }
}
