package com.programming.leetcode.Easy;

import java.util.Arrays;

public class LargestPerimeterTriangle {

    boolean isValidPair(int[] input, int startIndex){
        if(input[startIndex-2] + input[startIndex-1] > input[startIndex])
            return true;
        return false;
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i = A.length-1; i >= 2; i--){
            if(isValidPair(A, i)){
                return A[i-1]+A[i-2]+A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new LargestPerimeterTriangle().largestPerimeter(new int[]{2,1,2}));
        System.out.println(new LargestPerimeterTriangle().largestPerimeter(new int[]{1,1,2}));
        System.out.println(new LargestPerimeterTriangle().largestPerimeter(new int[]{2,3,3,4}));
        System.out.println(new LargestPerimeterTriangle().largestPerimeter(new int[]{2,6,3,3}));
    }

}
