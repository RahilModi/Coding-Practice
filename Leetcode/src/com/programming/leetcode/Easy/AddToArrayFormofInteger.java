package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormofInteger {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        for(int i = A.length-1; i >= 0; i--){
            res.add(0, (A[i]+K)%10);
            K = (A[i]+K)/10;
        }
        while (K>0){
            res.add(0, K%10);
            K/=10;
        }
        return res;
    }

    public List<Integer> addToArrayFormV1(int[] A, int K) {
        List res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0 || K > 0; --i) {
            res.add(0, (i >= 0 ? A[i] + K : K) % 10);
            K = (i >= 0 ? A[i] + K : K) / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        AddToArrayFormofInteger obj = new AddToArrayFormofInteger();
        System.out.println(obj.addToArrayForm(new int[]{1,2,0,0},123));
    }

}
