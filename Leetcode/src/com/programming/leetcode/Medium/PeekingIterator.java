package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer>{

    private Integer next;
    private Iterator<Integer> itr;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        itr = iterator;
        next = itr.hasNext() ? itr.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer crtAns = next;
        next = itr.hasNext() ? itr.next() : null;
        return crtAns;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(3);
        PeekingIterator obj = new PeekingIterator(res.iterator());
        System.out.println(obj.peek());
        System.out.println(obj.next());
    }
}
