package com.programming.leetcode.Medium;

import java.util.Stack;

public class MaxWidthRamp {

    public int maxWidthRamp(int[] A) {
        if(A == null || A.length == 0) return 0;
        int ptr1, ptr2, crtMax = 0;
        for(int i = 0; i < A.length; i++){
            ptr1 = i;
            ptr2 = A.length-1;
            while(ptr1 < ptr2 && ptr2 - ptr1 > crtMax){
                if(A[ptr2] >= A[ptr1]) {
                    crtMax = Math.max(crtMax, ptr2-ptr1);
                    break;
                }
                ptr2--;
            }
        }
        return crtMax;
    }

    public int maxWidthRampV1(int[] A){
        if(A == null || A.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < A.length; i++){
            if(stack.isEmpty() || A[stack.peek()] > A[i]) stack.push(i);
        }

        int crtMax = 0;
        for(int i = A.length-1;i>=0;i--){
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]){
                crtMax = Math.max(crtMax, i - stack.pop());
            }
        }
        return crtMax;
    }

    public static void main(String[] args) {
        MaxWidthRamp obj = new MaxWidthRamp();
        System.out.println(obj.maxWidthRampV1(new int[]{9,8,1,0,1,9,4,0,4,1}));
    }
}
