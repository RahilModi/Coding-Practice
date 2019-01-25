package com.programming.leetcode.Hard;

import com.programming.leetcode.Medium.KthSmallestInSortedMatrix;

import java.util.PriorityQueue;

public class KthSmallestMultiPlication {

    //Memory limit Exceeds for input 9895, 28405, 100787757
    public int findKthNumber(int m, int n, int k) {
        if(m*n == k)return m*n;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n ; j++){
                pq.add(i*j);
                if(pq.size() > (m*n)-k+1){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }

    //O(m*log(m*n))
    public boolean enough(int x, int m, int n, int k){
        int count = 0;
        for(int i = 1; i <= m; i++){
            count += Math.min(x/i, n);
        }
        return count >= k;
    }
    public int findKthNumberUsingBinarySearch(int m, int n, int k) {
        int lo = 0,  hi = m*n;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(enough(mid,m,n,k)) hi =mid;
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }


    public static void main(String[] args) {
        KthSmallestMultiPlication obj = new KthSmallestMultiPlication();
        System.out.println(obj.findKthNumber(3,3,2));
    }

}
