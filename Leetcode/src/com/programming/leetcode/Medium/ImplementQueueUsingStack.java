package com.programming.leetcode.Medium;

import java.util.Stack;

public class ImplementQueueUsingStack {

    class MyQueue {
        Stack<Integer> stackIn, stackOut;
        /** Initialize your data structure here. */
        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stackIn.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(stackOut.empty()) moveStackInToStackOut();
            return stackOut.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(stackOut.empty()) moveStackInToStackOut();
            return stackOut.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stackOut.empty() && stackIn.empty();
        }

        private void moveStackInToStackOut(){
            while(!stackIn.empty()){
                stackOut.push(stackIn.pop());
            }
        }
    }

    public static void main(String[] args) {
        ImplementQueueUsingStack obj = new ImplementQueueUsingStack();
        MyQueue queue = obj.new MyQueue();
        queue.push(5);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.empty());
    }
}
