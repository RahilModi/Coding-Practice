package com.programming.leetcode.Medium;

import java.util.*;

public class RandomizedSet {

    Set<Integer> set;
    Random random;
    List<Integer> list;
    Map<Integer, Integer> nodeMap;
    public RandomizedSet() {
        set = new HashSet<>();
        random = new Random();
        nodeMap = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return set.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return new ArrayList<>(set).get(random.nextInt(set.size()));
    }


    /*
    MUCH BETTER>>>>
     */


    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insertV1(int val) {
        if (!nodeMap.containsKey(val)) {
            nodeMap.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean removeV1(int val) {
        if (nodeMap.containsKey(val)) {
            int index = nodeMap.get(val);
            nodeMap.remove(val);
            if (index < list.size()-1) {
                list.set(index, list.get(list.size()-1));
                nodeMap.put(list.get(list.size()-1), index);
            }
            list.remove(list.size()-1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandomV1() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        obj.insertV1(1);
        obj.insertV1(2);
        obj.insertV1(1);
        obj.insertV1(3);
        obj.removeV1(2);

    }
}
