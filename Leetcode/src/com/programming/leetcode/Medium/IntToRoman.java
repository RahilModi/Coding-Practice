package com.programming.leetcode.Medium;

public class IntToRoman {

    static final int[] vals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static final String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int val : vals){
            if(num == 0) break;
            while (num >= val) {
                num -= val;
                sb.append(romanNumbers[idx]);
            }
            idx++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntToRoman obj = new IntToRoman();
        System.out.println(obj.intToRoman(326));
        System.out.println(obj.intToRoman(1994));
    }
}
