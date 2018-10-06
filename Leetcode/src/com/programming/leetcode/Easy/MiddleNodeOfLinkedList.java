package com.programming.leetcode.Easy;

public class MiddleNodeOfLinkedList {

    public ListNode middleNode(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode slow = head;

        ListNode fast = head.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(new MiddleNodeOfLinkedList().middleNode(head).val);
    }

}
