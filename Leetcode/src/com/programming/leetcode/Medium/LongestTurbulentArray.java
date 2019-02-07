package com.programming.leetcode.Medium;

public class LongestTurbulentArray {

    public int maxTurbulenceSize(int[] A) {

        int i =1, incr = 1, decr = 1, result = 1;
        while (i < A.length){
            if(A[i] < A[i-1]){
                decr = incr +1;
                incr = 1;
            }else if(A[i] > A[i-1]){
                incr = decr+1;
                decr =1;
            }else{
                incr=decr=1;
            }
            result = Math.max(result,Math.max(incr,decr));
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestTurbulentArray obj = new LongestTurbulentArray();
        System.out.println(obj.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
    }

}
