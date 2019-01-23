package com.programming.leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponenets {

    public int numComponents(ListNode head, int[] G) {

        Set<Integer> numbers = new HashSet<>();
        for(int i : G) numbers.add(i);

        ListNode t = head;
        int num_components = 0;
        boolean num_found = false;
        while(t != null){
            int num = t.val;
            if(numbers.contains(num)){
                num_found = true;
            }else{
                if(num_found) num_components +=1;
                num_found = false;
            }
            t =t.next;
        }
        return num_found ? num_components+1 : num_components;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        System.out.println(new LinkedListComponenets().numComponents(head,new int[]{0,1,3}));
    }


}
