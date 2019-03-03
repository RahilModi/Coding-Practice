package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class ZigZagIterator {
    List<List<Integer>> input;
    int crtCol, crtRow, totalElements, counter;
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        input = new ArrayList<>();
        input.add(v1);
        input.add(v2);
        crtCol = crtRow = counter = 0;
        totalElements = input.stream().mapToInt(l -> (int)l.size()).sum();
    }

    public int next() {
        if(hasNext()){
            while(crtRow == input.size() || crtCol >= input.get(crtRow).size()){
                if(crtRow == input.size()){
                    crtCol++;
                    crtRow= 0;
                }else{
                    crtRow++;
                }
            }
            int val = input.get(crtRow).get(crtCol);
            crtRow++;
            counter++;
            return val;
        }else{
            return -1;
        }
    }

    public boolean hasNext() {
        return counter < totalElements;
    }
}
