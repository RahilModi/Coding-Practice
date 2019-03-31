package com.programming.leetcode.Medium;

public class ReverseLinkedListII {
//https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        int count = m;
        while(count-->1){
            prev = prev.next;
        }
        int diff = n-m;

        // 1 - 2 - 3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5
        ListNode start = prev.next;
        ListNode then = start.next;
        while(diff-->0){
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        return temp.next;

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

    }
}
