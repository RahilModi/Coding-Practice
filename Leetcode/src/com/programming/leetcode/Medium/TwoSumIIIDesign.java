package com.programming.leetcode.Medium;

import java.util.*;

public class TwoSumIIIDesign {

    Map<Integer, Integer> map;
    Set<Integer> num, sum;
    /** Initialize your data structure here. */
    public TwoSumIIIDesign() {
        map = new HashMap<>();
        num = new HashSet<>();
        sum = new HashSet<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)){
            map.put(number, 2);
        }else
            map.put(number,1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Iterator<Integer> itr = map.keySet().iterator();
        while (itr.hasNext()){
            int num1 = itr.next();
            int num2 = value-num1;
            if( map.containsKey(num2) && (num1 != num2 || map.get(num2)==2)) return true;
        }
        return false;
    }


    public void addV1(int number) {
        if(num.contains(number)) sum.add(number*2);
        else {
            Iterator<Integer> numIter = num.iterator();
            while (numIter.hasNext()){
                sum.add(numIter.next()+number);
            }
            num.add(number);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean findV1(int value) {
        return sum.contains(value);
    }
}
