package com.programming.leetcode.Medium;

import java.util.*;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
 interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
     boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
     Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
     List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size()-1; i >=0; i-- ){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger obj = stack.peek();
            if (obj.isInteger()) return true;
            obj = stack.pop();
            for (int i = obj.getList().size() - 1; i >= 0; i--) {
                stack.push(obj.getList().get(i));
            }
        }
        return false;
    }
}
