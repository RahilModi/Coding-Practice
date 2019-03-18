package com.programming.leetcode.Easy;

public class AddDigits {

    public int addDigits(int num) {
        return 1 + (num-1) % 9;
    }

    public static void main(String[] args) {
        AddDigits obj = new AddDigits();
        System.out.println(obj.addDigits(38));
    }
}
