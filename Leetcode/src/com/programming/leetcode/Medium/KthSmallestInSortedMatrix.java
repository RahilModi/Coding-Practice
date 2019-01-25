package com.programming.leetcode.Medium;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

    //Matrix is sorted in every row and column not between rows & columns
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int num_row=matrix.length, num_col = matrix[0].length;
        int total_elem = num_row * num_col;
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length ; j++){
                pq.add(matrix[i][j]);
                if(pq.size() > (total_elem-k+1)){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }


    //https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
    public int kthSmallestBinarySearch(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        KthSmallestInSortedMatrix obj = new KthSmallestInSortedMatrix();
        obj.kthSmallestBinarySearch(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8);
    }
}
