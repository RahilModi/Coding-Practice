package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {

    private Random random;
    private int[] wSum;
    public RandomPickWithWeight(int[] w) {
        for(int i = 1; i<w.length; i++){
            w[i] += w[i-1];
        }
        this.wSum = w;
        random = new Random();
    }

    public int pickIndex() {
        int val = random.nextInt(wSum[wSum.length-1])+1;
        System.out.println(val);
        int pos = Arrays.binarySearch(wSum, 0, wSum.length-1, val); // pos = helperBinarySearch(0, wSum.length-1, val);
        return  pos < 0 ? -pos-1 : pos;
    }

    private int helperBinarySearch(int l, int r, int target){
        while(l < r){
            int mid = l + (r-l)/2;
            if(wSum[mid] == target)
                return mid;
            else if(wSum[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        RandomPickWithWeight obj = new RandomPickWithWeight(new int[]{1,3});
        System.out.println(obj.pickIndex());
    }

}
