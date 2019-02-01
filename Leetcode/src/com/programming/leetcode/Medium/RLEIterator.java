package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RLEIterator {

    List<Integer> nums = new ArrayList<>();
    Iterator<Integer> numsIterator;
    int lastReadPointer = 0;

    int[] numOfVals;
    int[] actualVal;
    int crtIndex = 0;
    public RLEIterator(int[] A) {
        numOfVals = new int[A.length/2];
        actualVal = new int[A.length/2];
        int idx =0;
        for(int i = 0; i < A.length; i+=2){
//            int j = 0;
//            while(j < A[i]){
//                nums.add(A[i+1]);
//                j++;
//            }
            numOfVals[idx] = A[i];
            actualVal[idx] = A[i+1];
            idx++;
        }
        //numsIterator = nums.iterator();
    }

    public int nextV1(int n) {
        //int j = 0;
        int res = -1;
//        while(j < n && numsIterator.hasNext()){
//            res = numsIterator.next();
//            j++;
//        }
        if(lastReadPointer + (n-1) <= (nums.size()-1)){
            lastReadPointer += (n-1);
            res = nums.get(lastReadPointer);
            lastReadPointer++;
        }
        return  res;
    }

    public int next(int n) {
        int j = 0;
        int res = -1;
        while(j < n && crtIndex < numOfVals.length) {
            if (crtIndex == (numOfVals.length-1) && numOfVals[crtIndex] < (n-j)) {
                numOfVals[crtIndex] = 0;
                crtIndex++;
            }
            else if(numOfVals[crtIndex] >= (n-j)){
                numOfVals[crtIndex] -=(n-j);
                j += (n-j);
            }
            else if(numOfVals[crtIndex]< (n-j)){
                j+=numOfVals[crtIndex];
                crtIndex++;
            }
        }
        return j==n ? actualVal[crtIndex]:-1;
    }

    public static void main(String[] args) {
        RLEIterator obj = new RLEIterator(new int[]{3,8,0,9,2,5});
        System.out.println(obj.next(2));
        System.out.println(obj.next(1));
        System.out.println(obj.next(2));
        System.out.println(obj.next(2));

    }
}
