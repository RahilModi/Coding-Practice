package com.programming.leetcode.Medium;

public class RotateFunction {

    public int maxRotateFunction(int[] A) {
        int i = 0;
        int max_sum = Integer.MIN_VALUE;
        while(i < A.length){
            max_sum = Math.max(max_sum, FunctionVal(A));
            rotateAnArray(A);
            i++;
        }
        return max_sum;
    }

    public void rotateAnArray(int[] A){
        int temp = A[A.length-1];
        for(int i = A.length-2; i >=0; i--){
            A[i+1]=A[i];
        }
        A[0] = temp;
    }

    public int FunctionVal(int[] A){
        int sum = 0;
        int idx = 0;
        for(int i : A){
            sum += (i * idx);
            idx++;
        }
        return sum;
    }

    public int maxRotateFunctionV1(int[] A){
        int allSum = 0;
        int len = A.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * A[i];
            allSum += A[i];
        }
        int max = F;

        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * A[i];
            max = Math.max(F, max);
        }
        return max;
    }

    public static void main(String[] args) {
        RotateFunction obj = new RotateFunction();
        System.out.println(obj.maxRotateFunctionV1(new int[]{1,2,3,4}));
    }
}
