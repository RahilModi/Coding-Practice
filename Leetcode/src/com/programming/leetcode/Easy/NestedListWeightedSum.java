package com.programming.leetcode.Easy;

import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
 interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }

public class NestedListWeightedSum {
    public int depthSum(List<NestedInteger> nestedList){
        return depthSumRecursive(nestedList, 1);
    }

    private int depthSumRecursive(List<NestedInteger> list, int depth){
        if(list == null) return 0;
        int sum = 0;
        for(NestedInteger i : list){
            if(i.isInteger()) sum += i.getInteger() * depth;
            else
                sum += depthSumRecursive(i.getList(), depth+1);
        }
        return sum;
    }
}
