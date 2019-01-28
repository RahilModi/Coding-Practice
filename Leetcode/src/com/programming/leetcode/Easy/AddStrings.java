package com.programming.leetcode.Easy;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder bld = new StringBuilder();
        int carry = 0, sum = 0;
        for(int i = num1.length()-1, j = num2.length()-1; i >= 0 || j >= 0; i--,j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sum = x + y +carry;
            bld.append(sum % 10);
            carry = sum / 10;
        }
        if(carry == 1) bld.append(carry);
        return bld.reverse().toString();
    }
}
