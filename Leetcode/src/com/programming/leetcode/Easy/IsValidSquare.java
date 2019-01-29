package com.programming.leetcode.Easy;

public class IsValidSquare {

    public boolean isPerfectSquare(int num) {
        if(num == 0) return false;
        return binarySearch(0,num,num);
    }

    private boolean binarySearch(long l, long r, int target){
        if(l > r ) return false;
        long mid = l + (r-l)/2;
        if(mid * mid == target) return true;
        else if(mid * mid < target) l = mid +1;
        else r = mid - 1;
        return binarySearch(l,r,target);
    }

    public static void main(String[] args) {
        IsValidSquare obj = new IsValidSquare();
        System.out.println(obj.isPerfectSquare(16));
        System.out.println(obj.isPerfectSquare(20));
        System.out.println(obj.isPerfectSquare(0));

    }
}
