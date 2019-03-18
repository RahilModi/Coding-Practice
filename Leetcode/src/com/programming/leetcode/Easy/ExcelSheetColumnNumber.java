package com.programming.leetcode.Easy;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); result = result * 26 + (s.charAt(i) - 'A' + 1), i++) ;
        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
        System.out.println(obj.titleToNumber("AB"));
        System.out.println(obj.titleToNumber("AZY"));
    }
}
