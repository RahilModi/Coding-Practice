package com.programming.leetcode.Medium;

import java.util.*;

public class NestedListWeightSumII {


    //[[1,1],2,[1,1]]  , [1,[4,[6]]]

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweighted = 0, weighted = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger())
                    unweighted += ni.getInteger();
                else
                    nextLevel.addAll(ni.getList());
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
    }

    public int depthSumInverseBFS(List<NestedInteger> nestedList){
        if(nestedList == null || nestedList.size() == 0) return 0;
        int prev, total;
        prev = total = 0;
        Queue<NestedInteger> queue= new LinkedList<>();
        for(NestedInteger num : nestedList){
            queue.offer(num);
        }
        while(!queue.isEmpty()){
            int levelSum = 0;
            for(int size = queue.size(); size > 0 ; size--){
                NestedInteger crt = queue.poll();
                if(crt != null){
                    if(crt.isInteger()) levelSum += crt.getInteger();
                    else{
                        queue.addAll(crt.getList());
                    }
                }
            }
            prev += levelSum;
            total += prev;
        }
        return total;
    }
}
