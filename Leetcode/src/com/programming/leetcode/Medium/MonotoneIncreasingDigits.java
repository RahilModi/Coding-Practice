package com.programming.leetcode.Medium;

public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        if(N < 10) return N;
        char[] digits = (N+"").toCharArray();
        int marker = digits.length;
        for(int i = digits.length-1; i > 0; i--){
            if(digits[i] < digits[i-1]){
                marker = i-1;
                digits[marker]--;
            }
        }

        for(int i = marker+1; i < digits.length; i++){
            digits[i] = '9';
        }

        return Integer.parseInt(String.valueOf(digits));
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits obj = new MonotoneIncreasingDigits();
        System.out.println(obj.monotoneIncreasingDigits(1254));
        System.out.println(obj.monotoneIncreasingDigits(1234));
        System.out.println(obj.monotoneIncreasingDigits(332));
    }

}
