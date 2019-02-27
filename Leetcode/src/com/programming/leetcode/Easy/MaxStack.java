package com.programming.leetcode.Easy;

import java.util.Stack;

public class MaxStack {

    //O(N) solution.....
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        pushHelper(x);
    }

    public void pushHelper(int x){
        int tempMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if( x > tempMax) {
            tempMax = x;
        }
        stack.push(x);
        maxStack.push(tempMax);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.pop();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int crtMax = maxStack.peek();
        Stack<Integer> temp = new Stack<>();
        while(stack.peek() != crtMax){
            temp.push(stack.pop());
            maxStack.pop();
        }
        stack.pop();
        maxStack.pop();
        while(!temp.isEmpty()){
            pushHelper(temp.pop());
        }
        return crtMax;
    }


}
