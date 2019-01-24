package com.programming.leetcode.Medium;

import java.util.Stack;

public class FlattenList {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        Stack<Node> nodeStack = new Stack<>();
        Node myHead = new Node(0,null,head,null);
        Node temp = myHead;
        nodeStack.push(head);
        while (!nodeStack.isEmpty()) {
            temp.next = nodeStack.pop();
            temp.next.prev = temp;
            temp = temp.next;
            while (temp.child != null || temp.next != null) {
                if(temp.child != null){
                    if(temp.next != null){
                        nodeStack.push(temp.next);
                    }
                    temp.next = temp.child;
                    temp.child.prev = temp;
                    temp.child = null;
                }
                temp = temp.next;
            }
        }
        head.prev=null;
        return  head;
    }

    public static void main(String[] args) {
        FlattenList fl = new FlattenList();
        Node node1= new Node(1,null,null,null);
        Node node2 = new Node(2,null,null,null);
        Node node3 = new Node(3,null,null,null);
        Node node4 = new Node(4,null,null,null);
        Node node5 = new Node(5,null,null,null);
        Node node6 = new Node(6,null,null,null);
        Node node7 = new Node(7,null,null,null);
        Node node8 = new Node(8,null,null,null);
        Node node9 = new Node(9,null,null,null);
        node1.next = node2; node2.prev = node1;
        node2.next = node3; node3.prev = node2; node3.child = node4;
        node3.next = new Node(11,node3,null,null);
        node4.next = node5;
        node5.next = node6; node5.prev = node4;
        node6.child = node7; node6.prev = node5; node6.next = new Node(10,node5,null,null);
        node7.next = node8;
        node8.next = node9;node8.prev=node7;
        node9.prev = node8;
        Node test = fl.flatten(node1);
        while(test != null){
            System.out.print(test.val+" -> ");
            test = test.next;
        }
    }
}
