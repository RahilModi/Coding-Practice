package com.programming.leetcode.Medium;

import java.util.Stack;

public class BSTtoDoublyLL {

    static class Node{

        int val;
        Node left = null;
        Node right = null;

        public Node(int val) {
            this.val = val;
        }
    }


    Node prev1 = null, head1 = null;
    Node bstToDoublyLL(Node root){
        if(root == null) return null;
        inOrderTraversal(root);
        prev1.right = head1;
        head1.left = prev1;
        return head1;
    }

    void inOrderTraversal(Node node){
        if(node == null) return ;
        inOrderTraversal(node.left);
        if(prev1 == null){
            head1 = node;
        }else{
            prev1.right = node;
            node.left = prev1;
        }
        prev1 = node;
        inOrderTraversal(node.right);
    }

    //Following will convert BST to Doubly LL not circular
    Node prev = null, head = null;
    Node bstToDoublyLLRecursive(Node root){
        if(root == null) return null;
        bstToDoublyLLRecursive(root.left);
        if(prev == null) head = root;
        else{
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        bstToDoublyLLRecursive(root.right);
        return head;
    }


    Node bstToDoublyLLUsingStack(Node node){
        if(node == null) return node;
        Node prev = null, head = prev;
        Stack<Node> stack = new Stack<>();
        while(node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(prev == null) head = node;
            else{
                prev.right = node;
                node.left = prev;
            }
            prev = node;
            node = node.right;
        }
        head.left = prev;
        prev.right = head;
        return head;
    }





    public static void main(String[] args) {
        Node root = new Node(4);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(5);
        root.left = n2;
        n2.left = n1;
        n2.right = n3;
        root.right =n4;

        Node test = new BSTtoDoublyLL().bstToDoublyLLUsingStack(root);

        //Node newHEadCircularLL = new BSTtoDoublyLL().bstToDoublyLL(root);

       // Node newHEad = new BSTtoDoublyLL().bstToDoublyLLRecursive(root);


    }


}
