package com.programming.leetcode.Medium;

public class CircularDeque {

    class Node{
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }

    int size, capacity;
    Node head, tail;

    public CircularDeque(int k) {
        this.size = 0;
        this.capacity = k;
        this.head = null;
        this.tail = null;
    }

    public boolean insertFront(int value) {

        if(size == capacity) return false;
        Node new_node = new Node(value);
        if(size==0){
            head = new_node;
            tail = head;
        }else{
            new_node.next=head;
            head.prev = new_node;
            head = new_node;
        }
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size == capacity) return false;
        Node new_node = new Node(value);
        if(size==0){
            tail = new_node;
            head = tail;
        }else{
            new_node.prev = tail;
            tail.next = new_node;
            tail = new_node;
        }
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0) return false;
        if(size == 1) {
            head = tail = null;
        }else {
            head = head.next;
            tail.next = head;
            head.prev = tail;
        }
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0) return false;
        if(size == 1) {
            head = tail = null;
        }else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return size == 0 ? -1 : head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return size == 0 ? -1 : tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        CircularDeque circularDeque = new CircularDeque(3); // set the size to be 3
        circularDeque.insertLast(1);            // return true
        circularDeque.insertLast(2);            // return true
        circularDeque.insertFront(3);            // return true
        circularDeque.insertFront(4);            // return false, the queue is full
        circularDeque.getRear();            // return 2
        circularDeque.isFull();                // return true
        circularDeque.deleteLast();            // return true
        circularDeque.insertFront(4);            // return true
        circularDeque.getFront();
    }
}
