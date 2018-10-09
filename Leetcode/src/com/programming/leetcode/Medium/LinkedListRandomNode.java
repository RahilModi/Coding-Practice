package com.programming.leetcode.Medium;

import com.programming.leetcode.Medium.ListNode;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class LinkedListRandomNode {

    ListNode root = null;
    Random random = null;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.root = head;
        this.random = new Random(41);
    }

    /** Returns a random node's value. */
    public int getRandom() {

        ListNode crt = this.root;

        int result = crt.val;

        for(int n = 1 ; crt.next != null; n++){

            crt = crt.next;
            if(random.nextInt(n+1) == n){
                result = crt.val;
            }
        }

        return result;
    }

}
