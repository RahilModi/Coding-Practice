package com.programming.leetcode.Medium;

public class MyCircularQueue {

        class qNode{
            int val;
            qNode next;

            public qNode(int val, qNode next) {
                this.val = val;
                this.next = next;
            }

            public int getVal() {
                return val;
            }

            public void setVal(int val) {
                this.val = val;
            }

            public qNode getNext() {
                return next;
            }

            public void setNext(qNode next) {
                this.next = next;
            }
        }

        private int size, capacity;
        private qNode head,tail;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            this.capacity = k;
            this.size = 0;
            head = null;
            tail = null;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(size == capacity) return false;
            if(size == 0) {
                head = new qNode(value,null);
                tail = head;
            }else{
                tail.next = new qNode(value,null);
                tail = tail.next;
            }
            size++;
            if(isFull()) tail.next = head;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(size == 0) return false;
            head = head.next;
            size--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if(size == 0) return -1;
            return head.val;
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if(size == 0) return -1;
            return tail.val;
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size==0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == capacity;
        }


    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.enQueue(2));  // return true
        System.out.println(circularQueue.enQueue(3));  // return true
        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
        System.out.println(circularQueue.Rear());  // return 3
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4
    }
}
