package com.programming.leetcode.Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
        if(nestedList == null || nestedList.isEmpty()) return 0;
        int prev = 0, total = 0;
        Queue<NestedInteger> q= new ArrayDeque<>();
        for(NestedInteger next: nestedList){
            q.offer(next);
        }
        while (!q.isEmpty()){
            int size = q.size();
            int levelSum = 0;
            for(int i = 0; i < size; i++){
                NestedInteger crt = q.poll();
                if(crt.isInteger()) levelSum += crt.getInteger();
                else{
                    List<NestedInteger> nextLevel = crt.getList();
                    if(nextLevel != null){
                        for(NestedInteger n : nextLevel){
                            q.offer(n);
                        }
                    }
                }
            }
            prev += levelSum;
            total += prev;
        }
        return total;
    }
}
