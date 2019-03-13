package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        char[] digits = (n+"").toCharArray();

        int i;
        for(i = digits.length-1; i > 0; i--){
            if (digits[i-1] < digits[i]) {
                break;
            }
        }
        if(i == 0) return -1;
        char x = digits[i-1];
        int smallest = i;
        for(int j = i+1 ; j < digits.length; j++){
            if(digits[j] > x && digits[j] <= digits[smallest]){
                smallest = j;
            }
        }

        digits[i-1] = digits[smallest];
        digits[smallest] = x;

        Arrays.sort(digits, i, digits.length);

        long val = Long.parseLong(new String(digits));
        return val > Integer.MAX_VALUE ? -1 : (int)val;

    }

    public static void main(String[] args) {
        NextGreaterElementIII obj = new NextGreaterElementIII();
        System.out.println(obj.nextGreaterElement(12));
    }

}
