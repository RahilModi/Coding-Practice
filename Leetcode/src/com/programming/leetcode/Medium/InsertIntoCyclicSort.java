package com.programming.leetcode.Medium;

public class InsertIntoCyclicSort {


    public ListNode insertNodeIntoCyclicSort(ListNode node, int val){
        if(node == null) {
            node = new ListNode(val);
            node.next = node;
            return node;
        }
        ListNode prev = node, crt = node.next;
        while(crt != node){
            if(prev.val <= val && crt.val >= val ) break;
            if(prev.val > crt.val  && (prev.val <= val || crt.val >= val)) break; //to condition when upper element is connected to lower element  like  1->3->4 but 4 is also connected to 1
            prev =crt;
            crt = crt.next;
        }
        prev.next = new ListNode(val);
        return node;
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode helper =  new ListNode(0);
        ListNode pre =  helper;
        ListNode crt = head;
        ListNode next =  null;
        while(crt != null){
            next = crt.next;
            pre=helper;
            while(pre.next != null && pre.next.val <= crt.val){
                pre = pre.next;
            }
            crt.next = pre.next;
            pre.next = crt;
            crt = next;
        }
        return helper.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode n1 = new ListNode(4); head.next = n1;
        ListNode n2 = new ListNode(6); n1.next = n2;
        ListNode n3 = new ListNode(10); n2.next = n3;
        ListNode n4 = new ListNode(29); n3.next = n4;
        n4.next = head;

        InsertIntoCyclicSort obj = new InsertIntoCyclicSort();
        obj.insertNodeIntoCyclicSort(n3, 5);

    }
}
