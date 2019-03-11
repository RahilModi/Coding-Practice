package com.programming.leetcode.Hard;

import com.programming.leetcode.Medium.ListNode;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode crt = head;
        int count = 0;
        ListNode prev = null;
        while (crt != null && count != k) { // find the k+1 node
            crt = crt.next;
            count++;
        }
        if(count != k)
            return head;
        crt = head;
        ListNode next = null;
        while(crt != null && count > 0){
            next = crt.next;
            crt.next = prev;
            prev = crt;
            crt = next;
            count--;
        }
        if(next != null){
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }

    public ListNode reverseKGroupV1(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev, start, then, tail;
        tail = prev = newHead;
        start = prev.next;
        while (true) {
            // check if there's k nodes left-out
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null)
                    return newHead.next;
            }
            // reverse k nodes
            int count = k;
            while (count-- > 1){
                then = start.next;
                start.next = then.next;
                then.next = prev.next;
                prev.next = then;
            }
            tail = prev = start;
            start = prev.next;
        }
    }
}
