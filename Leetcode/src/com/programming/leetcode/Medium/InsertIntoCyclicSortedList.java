package com.programming.leetcode.Medium;

public class InsertIntoCyclicSortedList {

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    };

    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node crt = new Node(insertVal, null);
            crt.next = crt;
            return crt;
        }
        Node crt = head;
        while (true){
            if(crt.val < crt.next.val){
                if(crt.val <= insertVal && insertVal <= crt.next.val){
                    insertAfter(crt,insertVal);
                    break;
                }
            }
            else if(crt.val > crt.next.val){
                if(crt.val <= insertVal && insertVal  <= crt.next.val){
                    insertAfter(crt,insertVal);
                    break;
                }
            }else if(crt.next == head){
                insertAfter(crt, insertVal);
                break;
            }
            crt = crt.next;
        }
        return head;
    }

    private void insertAfter(Node crt, int val){
        crt.next = new Node(val, crt.next);
    }
}
