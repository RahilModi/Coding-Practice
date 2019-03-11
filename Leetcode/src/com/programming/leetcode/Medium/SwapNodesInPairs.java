package com.programming.leetcode.Medium;

import java.util.List;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairsV1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode crt = dummy;
        while (crt.next != null && crt.next.next != null){
            ListNode first = crt.next;
            ListNode second  = crt.next.next;
            first.next = second.next;
            crt.next = second;
            crt.next.next = first;
            crt = crt.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairsV2(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode crt = head.next;
        ListNode node = crt;
        while(true){
            ListNode next = crt.next;
            crt.next = prev;
            if(next == null || next.next == null)  {
                prev.next = next;
                break;
            }
            prev.next = next.next;
            prev = next;
            crt = prev.next;
        }
        return node;
    }
}
