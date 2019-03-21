package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class SmallestRange {

    //instead of class we can also use int[] just like did in brick wall solution...
    class Element{
        int val, row, idx;

        public Element(int val, int row, int idx) {
            this.val = val;
            this.row = row;
            this.idx = idx;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        int maxVal = Integer.MIN_VALUE, range = Integer.MAX_VALUE, start = -1, end = -1;
        for(int i = 0; i < nums.size(); i++){
            pq.offer(new Element(nums.get(i).get(0), i, 0));
            maxVal = Math.max(nums.get(i).get(0), maxVal);
        }
        while (pq.size() == nums.size()){
            Element crt = pq.poll(); // will return min val from the K rows;
            if(maxVal - crt.val < range){
                start = crt.val;
                end = maxVal;
                range = end - start;
            }
            if(crt.idx + 1 < nums.get(crt.row).size()){
                crt.idx += 1;
                crt.val = nums.get(crt.row).get(crt.idx);
                pq.offer(crt);
                if(crt.val > maxVal) maxVal = crt.val;
            }
         }
        return new int[]{start,end};
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.stream(new int[]{4,10,15,24,26}).boxed().collect(Collectors.toList()));
        input.add(Arrays.stream(new int[]{0,9,12,20}).boxed().collect(Collectors.toList()));
        input.add(Arrays.stream(new int[]{5,18,22,30}).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.toString(new SmallestRange().smallestRange(input)));
    }

}
