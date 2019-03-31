package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

    //A.length < 3000
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < A.length; i++){
            res.add(Integer.parseInt(sb.append(A[i]).toString(),2)%5==0);
        }
        return res;
    }

    //If X is the first i digits of the array as a binary number, then 2X + A[i] is the first i+1 digits.
    public List<Boolean> prefixesDivBy5V1(int[] A) {
        List<Boolean> res = new ArrayList<>();
        for(int i = 0, crtNum = 0; i < A.length; i++){
            crtNum = (2*crtNum % 5) + A[i];
            res.add(crtNum%5 == 0);
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryPrefixDivisibleBy5 obj = new BinaryPrefixDivisibleBy5();
        System.out.println(obj.prefixesDivBy5(new int[]{0,1,1,1,1,1}));
    }

}
