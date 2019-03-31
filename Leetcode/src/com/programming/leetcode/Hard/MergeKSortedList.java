package com.programming.leetcode.Hard;

import com.programming.leetcode.Medium.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (o1, o2)->Integer.compare(o1.val, o2.val));
        ListNode dummy = new ListNode(0), n1 = dummy;
        for(ListNode node : lists){
            if(node!=null){
                pq.add(node);
            }
        }
        while(!pq.isEmpty()){
            n1.next = pq.poll();
            n1 = n1.next;
            if(n1.next!=null){
                pq.add(n1.next);
            }
        }

        return dummy.next;
    }
}
