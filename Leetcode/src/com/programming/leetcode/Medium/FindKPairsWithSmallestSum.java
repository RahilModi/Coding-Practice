package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSum {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length==0||k==0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        for(int i =0; i < nums1.length; i++) pq.offer(new int[]{nums1[i], nums2[0], 0});
        while (k-->0 && !pq.isEmpty()){
            int[] crt = pq.poll();
            res.add(new int[]{crt[0],crt[1]});
            if(crt[2] == nums2.length-1) continue;
            pq.add(new int[]{crt[0], nums2[crt[2]+1], crt[2]+1});
        }
        return res;
    }

}
