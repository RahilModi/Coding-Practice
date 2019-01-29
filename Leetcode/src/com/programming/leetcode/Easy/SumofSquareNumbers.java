package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class SumofSquareNumbers {

    public boolean judgeSquareSum(int c) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i <= Math.sqrt(c); i++){
            int sq = i * i;
            if(map.containsKey(sq) || (c-sq == sq)){
                return true;
            }else{
                map.put(c-sq, i);
            }
        }
        return false;
    }

    public boolean judgeSquareSumV2(int c) {
        for(int i = 0 ; i <= Math.sqrt(c); i++){
            int sq = i * i;
            double b = Math.sqrt(c-sq);
            if(b == (int)b) return true;
        }
        return false;
    }

    public boolean judgeSquareSumV3(int c) {
        for(int i = 0 ; i <= Math.sqrt(c); i++){
            int b = c - (int)(i * i);
            if(binarySearch(0,b,b)) return true;
        }
        return false;
    }

    boolean binarySearch(long s, long e, int target){
        if(s > e) return false;
        long mid = s + (e-s)/2;
        if(mid * mid == target) return true;
        else if(mid * mid < target) s = mid+1;
        else e = mid - 1;
        return binarySearch(s,e,target);
    }

    public static void main(String[] args) {
        SumofSquareNumbers obj = new SumofSquareNumbers();
        System.out.println(obj.judgeSquareSum(5));
        System.out.println(obj.judgeSquareSum(3));
        System.out.println(obj.judgeSquareSum(2));
    }

}
