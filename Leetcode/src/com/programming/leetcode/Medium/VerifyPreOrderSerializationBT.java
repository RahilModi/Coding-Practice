package com.programming.leetcode.Medium;

public class VerifyPreOrderSerializationBT {

    int index = 0;
    boolean isPossible = true;
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.isEmpty()) return false;
        String[] splited = preorder.split(",");
        makeTree(splited);
        return index==splited.length-1 && isPossible;
    }

    public TreeNode makeTree(String[] input){
        if(index >= input.length) {
            isPossible = false;
            return null;
        }
        if(input[index].equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(input[index]));
        if(node != null){
            index++;
            node.left = makeTree(input);
            index++;
            node.right = makeTree(input);
        }
        return node;
    }


    public boolean isValidSerializationV1(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        VerifyPreOrderSerializationBT obj = new VerifyPreOrderSerializationBT();
        System.out.println(obj.isValidSerialization("1,#"));
    }
}
