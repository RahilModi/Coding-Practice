package com.programming.leetcode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] A, int K) {
        int max = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int l = 0, h = 0; h < A.length; h++){
            if(A[h] == 0){
                queue.offer(h);
            }
            if(queue.size() > K){
                l = queue.poll() +1;
            }
            max= Math.max(max, h-l+1);
        }
        return max;
    }


    public int longestOnesV1(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }

    public int longestOnesV2(int[] A, int K) {
        int zeroCount=0,start=0,res=0;
        for(int end=0;end<A.length;end++){
            if(A[end] == 0) zeroCount++;
            while(zeroCount > K){
                if(A[start] == 0) zeroCount--;
                start++;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }


    public static void main(String[] args) {
        MaxConsecutiveOnesIII obj = new MaxConsecutiveOnesIII();
        System.out.println(obj.longestOnesV1(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }

}
