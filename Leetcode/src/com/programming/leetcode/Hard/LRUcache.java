package com.programming.leetcode.Hard;

import com.sun.org.apache.bcel.internal.generic.DLOAD;

import java.util.HashMap;

public class LRUcache {


    class DLinkNode{
        int key, val;
        DLinkNode pre, post;

        public DLinkNode(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            post = null;
        }
    }

    HashMap<Integer, DLinkNode> cache;
    DLinkNode head, tail;
    int count, capacity;

    public LRUcache(int capacity) {

        this.capacity = capacity;
        cache = new HashMap<>();
        this.head = new DLinkNode(0,0);
        this.tail = new DLinkNode(0,0);

        head.post = tail;
        tail.pre = head;
        this.count = 0;

    }

    private void addNode(DLinkNode node){
        node.pre = head;
        head.post.pre = node;
        node.post = head.post;
        head.post = node;
    }

    private void removeNode(DLinkNode node){
        DLinkNode pre = node.pre;
        DLinkNode post = node.post;

        pre.post = post;
        post.pre = pre;

    }

    private void moveNextToHead(DLinkNode node){
        removeNode(node);
        addNode(node);
    }

    private void popFromTail(){
        DLinkNode prevOfTail = tail.pre;
        this.removeNode(prevOfTail);
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            DLinkNode node = cache.get(key);
            moveNextToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkNode node = null;
        if(!cache.containsKey(key)){
            node = new DLinkNode(key, value);
            if(count == capacity) {
                this.cache.remove(tail.pre.key);
                this.popFromTail();
                addNode(node);
            }else{
                addNode(node);
                count++;
            }
        }else{
            node = cache.get(key);
            node.val = value;
            this.moveNextToHead(node);
        }
        this.cache.put(key,node);
    }
}
