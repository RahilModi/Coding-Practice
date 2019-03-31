package com.programming.leetcode.Easy;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null, next = null, crt = head;
        while (crt.next != null){
            next = crt.next;
            crt.next = prev;
            prev = crt;
            crt = next;
        }
        crt.next = prev;
        return crt;
    }
}
