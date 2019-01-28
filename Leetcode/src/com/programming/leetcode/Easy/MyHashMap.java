package com.programming.leetcode.Easy;

import java.util.Arrays;

public class MyHashMap {
    int num_buckets = 1000;
    int num_items_bucket = 1001;
    int[][] table;

    ListNode[] listNodes;

    public MyHashMap() {
        this.listNodes = new ListNode[1000000];
        this.table = new int[num_buckets][];
    }

    public void put(int key, int value){
        int bucketId = bucket_idx(key);
        if(this.table[bucketId] == null){
            this.table[bucketId]= new int[num_items_bucket];
            Arrays.fill(this.table[bucketId],-1);
        }
        this.table[bucketId][pos_in_bucket(key)] = value;
    }

    public int get(int key){
        int bucketId = bucket_idx(key);
        if(this.table[bucketId] == null){
            return -1;
        }
        return this.table[bucketId][pos_in_bucket(key)];
    }

    public void remove(int key){
        int bucketId = bucket_idx(key);
        if(this.table[bucketId] != null) this.table[bucketId][pos_in_bucket(key)] = -1;
    }
    /** value will always be non-negative. */
    public void putV1(int key, int value) {
        int index = idx(key);
        if(listNodes[index] == null){
            listNodes[index] = new ListNode(-1,-1);
        }
        ListNode prev = find(this.listNodes[index], key);
        if(prev.next == null){
            prev.next = new ListNode(key,value);
        }
        prev.next.val = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int getV1(int key) {
        int index = idx(key);
        if (this.listNodes[index] == null) return -1;
        ListNode node = find(this.listNodes[index], key);
        return node.next == null ? -1 : node.next.val;
    }

    ListNode find(ListNode bucket, int key){
        ListNode node = bucket, prev = null;
        while(node != null && node.key != key){
            prev = node;
            node = node.next;
        }
        return prev;
    }


    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void removeV1(int key) {
        int index = idx(key);
        if (this.listNodes[index] == null) return;
        ListNode prev = find(this.listNodes[index],key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }

    int idx(int key){
        return Integer.hashCode(key) % this.listNodes.length;
    }

    int bucket_idx(int key){
        return Integer.hashCode(key) % this.num_buckets;
    }
    int pos_in_bucket(int key){
        return key / this.num_buckets;
    }

    static class ListNode{
        int key,val;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));            // returns -1 (not found)
    }
}
