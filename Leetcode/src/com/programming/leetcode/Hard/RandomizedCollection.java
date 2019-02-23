package com.programming.leetcode.Hard;

import java.util.*;

public class RandomizedCollection {

    Map<Integer,Set<Integer>> coll;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        coll = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        coll.computeIfAbsent(val, k-> new HashSet<>()).add(list.size());
        list.add(val);
        return coll.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!coll.containsKey(val)) return false;
        int pos = coll.get(val).iterator().next();
        coll.get(val).remove(pos);
        if(pos < list.size()-1){
            int num = list.get(list.size()-1);
            list.set(pos,num);
            coll.get(num).remove(list.size()-1);
            coll.get(num).add(pos);
        }
        list.remove(list.size()-1);
        if(coll.get(val).isEmpty()) coll.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
