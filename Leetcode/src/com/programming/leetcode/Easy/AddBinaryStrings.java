package com.programming.leetcode.Easy;

public class AddBinaryStrings {

    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder res = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        while (i>=0 && j >= 0){
            int c = (int)(a.charAt(i--)-'0') + (int)(b.charAt(j--)-'0') + carry;
            carry = c / 2;
            res.insert(0,c%2);
        }
        int idx = i >= 0 ? i : j;
        String temp = i >= 0 ? a : b;
        while (idx >= 0){
            if(carry == 1) {
                int c = (int) (temp.charAt(idx--) - '0') + carry;
                carry = c / 2;
                res.insert(0,c%2);
            }else{
                res.insert(0,temp.charAt(idx--));
            }
        }
        if(carry == 1) res.insert(0,carry);
        return res.toString();
    }

    public static void main(String[] args) {
        AddBinaryStrings obj = new AddBinaryStrings();
        System.out.println(obj.addBinary("11","1"));
        System.out.println(obj.addBinary("1","101"));
    }
}
