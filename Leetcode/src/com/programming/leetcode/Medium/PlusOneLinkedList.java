package com.programming.leetcode.Medium;

import com.programming.leetcode.Easy.PlusOne;

import java.util.Stack;

public class PlusOneLinkedList {
    class lNode{
        lNode next;
        int val;

        public lNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    lNode plusOne(lNode head){
        if(head == null) return null;
        int carry = helper(head);
        if(carry == 1){
            lNode newHead = new lNode(1);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    int helper(lNode node){
        if(node == null) return 1;
        int carry = helper(node.next);
        int sum = node.val + carry;
        node.val = sum % 10;
        return sum/10;
    }


    //Iterative Solution Using Stack
    lNode plusOneIterative(lNode head){
        Stack<lNode> stack = new Stack<>();
        if(head == null) return null;
        lNode temp = head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        int carry = 1;
        while(!stack.isEmpty() && carry == 1){
            lNode crt = stack.pop();
            int sum = crt.val + carry;
            crt.val = sum % 10;
            carry = sum/10;
        }
        if(carry==1) {
            lNode newHead = new lNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }


    public static void main(String[] args) {
        PlusOneLinkedList pOneLL = new PlusOneLinkedList();
        lNode node1 = pOneLL.new lNode(9);
        lNode node2 = pOneLL.new lNode(9);
        lNode node3 = pOneLL.new lNode(9);
        node1.next = node2;
        node2.next = node3;
        lNode newHead = pOneLL.plusOne(node1);
        lNode temp = newHead;
        while(temp.next != null){
            System.out.print(temp.val+" - ");
            temp = temp.next;
        }
        System.out.println(temp.val);

        node1.val = 9;
        node1.next = node2;
        node2.val = 7;
        node2.next = node3;
        node3.val = 7;
        temp = pOneLL.plusOneIterative(node1);
        while (temp.next != null){
            System.out.print(temp.val+" - ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }
}
