package com.programming.leetcode.Easy;

public class MyLinkedList {
    class lNode{
        int val;
        lNode next;

        public lNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    lNode head;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size) return -1;
        int crt = 0;
        lNode temp = head;
        while(crt != index && temp.next != null){
            temp = temp.next;
            crt++;
        }
        return crt == index  ? temp.val : -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        lNode t = new lNode(val);
        if(size != 0){
            t.next = head;
        }
        head = t;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        lNode new_node = new lNode(val);
        if(size == 0) {
            head = new_node;
        }else {
            lNode t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = new_node;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index == 0) addAtHead(val);
        else{
            int crt = 0;
            lNode temp = head;
            lNode prev = temp;
            while(crt != index && temp != null){
                prev = temp;
                temp = temp.next;
                crt++;
            }
            lNode n = new lNode(val);
            prev.next = n;
            n.next = temp;
        }
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size) return;
        if(index == 0) head = head.next;
        int crt = 0;
        lNode temp = head;
        lNode prev = null;
        while(crt != index && temp.next != null){
            prev = temp;
            temp = temp.next;
            crt++;
        }
        prev.next = temp.next;
        size--;
    }

    public void printList(){
        lNode temp = head;
        while(temp.next != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.val);
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        System.out.println(linkedList.get(0));
        linkedList.addAtHead(1);
        linkedList.addAtIndex(1,2);
        linkedList.printList();
        linkedList.addAtTail(3);
        linkedList.printList();
        linkedList.addAtIndex(1, 2);
        linkedList.printList();// linked list becomes 1->2->3
        linkedList.get(1);
        linkedList.printList();// returns 2
        linkedList.deleteAtIndex(1); linkedList.printList(); // now the linked list is 1->3
        linkedList.get(1);
        linkedList.printList();// returns 3
    }
}
