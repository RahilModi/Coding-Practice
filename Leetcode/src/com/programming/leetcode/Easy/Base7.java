package com.programming.leetcode.Easy;

public class Base7 {

    public String convertToBase7(int num) {
        if(num == 0)return "0";
        boolean isNegativeNum = num < 0;
        StringBuilder sb = new StringBuilder();
        num = Math.abs(num);
        while(num != 0){
            sb.insert(0,num%7);
            num /= 7;
        }
        if(isNegativeNum) sb.insert(0,'-');
        return sb.toString();
    }

    public static void main(String[] args) {
        Base7 obj = new Base7();
        System.out.println(obj.convertToBase7(100));
        System.out.println(obj.convertToBase7(-12));
    }
}
