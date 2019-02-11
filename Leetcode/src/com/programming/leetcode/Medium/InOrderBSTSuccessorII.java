package com.programming.leetcode.Medium;

public class InOrderBSTSuccessorII {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node inorderSuccessor(Node x) {
        if(x == null) return null;
        if(x.right == null){
            Node parent = x.parent;
            while (parent != null && parent.val < x.val){
                parent = parent.parent;
            }
            return parent;
        }else{
            Node t = x.right;
            while (t.left != null){
                t = t.left;
            }
            return t;
        }
    }

}
