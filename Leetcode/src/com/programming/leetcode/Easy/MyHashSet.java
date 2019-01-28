package com.programming.leetcode.Easy;

public class MyHashSet {
    int num_buckets = 1000;
    int item_per_bucket = 1001;
    boolean[][] table;

    public MyHashSet() {
        table = new boolean[num_buckets][];
    }

    public int hash_key(int key){
        return Integer.hashCode(key) % num_buckets;
    }

    public int pos_in_bucket(int key){
        return key / num_buckets;
    }

    public void add(int key) {
        int bucket_id = hash_key(key);
        if(this.table[bucket_id]==null) this.table[bucket_id] = new boolean[item_per_bucket];
        this.table[bucket_id][pos_in_bucket(key)] = true;
    }

    public void remove(int key) {
        int bucket_id = hash_key(key);
        if(this.table[bucket_id]!=null)
            this.table[bucket_id][pos_in_bucket(key)] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket_id = hash_key(key);
        if(this.table[bucket_id]==null) return false;
        return this.table[bucket_id][pos_in_bucket(key)];
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }
}
