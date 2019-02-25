package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        if(logs == null || logs.size() < 2*n) return res;
        Stack<Integer> logStack = new Stack<>();
        int prevTime = 0;
        for(String log : logs){
            String splitedLogs[] = log.split(":");
            int crtId = Integer.parseInt(splitedLogs[0]);
            int crtTime = Integer.valueOf(splitedLogs[2]);
            if(splitedLogs[1].equals("start")){
                if(!logStack.isEmpty())
                    res[logStack.peek()] += crtTime-prevTime;
                logStack.push(crtId);
                prevTime = crtTime;
            }
            else{
                res[logStack.pop()] += crtTime - prevTime +1;
                prevTime = crtTime +1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ExclusiveTimeOfFunctions obj = new ExclusiveTimeOfFunctions();
        System.out.println(Arrays.toString(obj.exclusiveTime(2, Arrays.asList(new String[]{"0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6"}))));
    }
}
