package com.programming.leetcode.Easy;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        int carry = 0;
        boolean badded = false;
        for(int i = digits.length - 1 ; i >= 0 ; i--){
            int num;
            if(badded){
                if(carry == 0) return digits;
                num = digits[i] + carry;
            }
            else{
                num = digits[i] + 1 + carry;
                badded = true;
            }
            if(num >= 10){
                carry = 1;
                digits[i] = num % 10;
            }else{
                digits[i] = num;
                carry = 0;
            }
        }

        if(carry > 0) {
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            return ans;
        }
        return digits;

    }

    public int[] plusOneV2(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;

    }

    public static void main(String[] args) {
        new PlusOne().plusOne(new int[]{4,3,2,1});
    }
}
