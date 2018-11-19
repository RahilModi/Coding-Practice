package com.programming.leetcode.Easy;

import java.util.Arrays;

public class ReorderLogs {

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (a, b) -> {
            String[] split_a = a.split(" ", 2);
            String[] split_b = b.split(" ", 2);
            boolean isDigits_a = Character.isDigit(split_a[1].charAt(0));
            boolean isDigits_b = Character.isDigit(split_b[1].charAt(0));

            if(!isDigits_a && !isDigits_b){
                int cmp = split_a[1].compareTo(split_b[1]);
                return cmp != 0 ? cmp : split_a[0].compareTo(split_b[0]);
            }else{
                return isDigits_a ? (isDigits_b ? 0 : 1) : -1;
            }
        });

        return logs;
    }

    public static void main(String[] args) {
        ReorderLogs obj = new ReorderLogs();
        obj.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
    }


}
