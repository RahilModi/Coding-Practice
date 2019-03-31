package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    class Node{
        int val, index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public int[] nextLargerNodes(ListNode head) {
        int len = 0;
        ListNode crt = head;
        while (crt != null){
            crt = crt.next;
            len++;
        }
        int res[] = new int[len];
        Stack<Node> stack = new Stack<>();
        crt = head;
        int index = 0;
        while (crt != null){
            while (!stack.isEmpty() && stack.peek().val < crt.val) {
                res[stack.pop().index]= crt.val;
            }
            stack.push(new Node(crt.val, index++));
            crt = crt.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(7);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        NextGreaterNodeInLinkedList obj = new NextGreaterNodeInLinkedList();
        System.out.println(Arrays.toString(obj.nextLargerNodes(head)));
    }

}
