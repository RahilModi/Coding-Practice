package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumTimeDifference {

    List<Integer> timeList = new ArrayList<>();

    public int findMinDifference(List<String> timePoints) {
        for(String time:timePoints){
            if(time.equals("00:00")){
                String[] arr = "24:00".split(":");
                timeList.add(Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]));
            }
            String[] arr = time.split(":");
            timeList.add(Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]));
        }

        Collections.sort(timeList);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < timeList.size()-1; i++){
            res = Math.min(timeList.get(i+1)-timeList.get(i), res);
        }
        res = Math.min(1440 - timeList.get(timeList.size()-1) + timeList.get(0), res);
        return res;
    }

    public static void main(String[] args) {
        MinimumTimeDifference obj = new MinimumTimeDifference();
        List<String> res = new ArrayList<>();
        res.add("23:59");
        res.add("00:00");
        System.out.println(obj.findMinDifference(res));
    }
}
