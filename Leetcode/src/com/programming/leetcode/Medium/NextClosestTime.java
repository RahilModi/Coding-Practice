package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//leetcode : 681
public class NextClosestTime {

    String ans = "";
    Integer minDiff = Integer.MAX_VALUE;
    public String nextClosestTime(String time) {
        Integer originalTimeInMins = Integer.valueOf(time.substring(0,2))*60
                                    + Integer.valueOf(time.substring(3,5));
        List<Integer> inputDigits = Arrays.stream(time.split("")).filter(s->!s.equals(":")).map(Integer::valueOf).collect(Collectors.toList());
        permuteUtil("",originalTimeInMins,inputDigits);
        return ans;
    }

    public void permuteUtil(String temp, int inputTime,  List<Integer> digits){
        if(temp.length() == 4) {
            String hours = temp.substring(0, 2);
            String mins = temp.substring(2);
            if (Integer.valueOf(hours) >= 24 || Integer.valueOf(mins) >= 59) return;
            int totalMins = Integer.valueOf(hours) * 60 + Integer.valueOf(mins);
            totalMins += totalMins <= inputTime ? (24 * 60) : 0;
            if (minDiff > totalMins - inputTime) {
                ans = temp.substring(0, 2) + ":" + temp.substring(2);
                minDiff = totalMins - inputTime;
            }
            return;
        }
        for(int i = 0; i < digits.size(); i++){
            temp+=digits.get(i);
            permuteUtil(temp,inputTime,digits);
            temp=temp.substring(0,temp.length()-1);
        }
        return;
    }

    public static void main(String[] args) {
        NextClosestTime obj = new NextClosestTime();
        System.out.println(obj.nextClosestTime("23:59"));
    }
}
