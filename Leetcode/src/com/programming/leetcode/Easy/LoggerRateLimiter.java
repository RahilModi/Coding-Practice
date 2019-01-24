package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    Map<String,Integer> temp = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String logMessage){

        Integer newTimeStampAtleast = temp.get(logMessage);
        if(newTimeStampAtleast != null) {
            if (timestamp < newTimeStampAtleast)
                return false;
        }
        temp.put(logMessage, timestamp+10);
        return true;

    }

    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();
        // logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo")); //returns true;

// logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2,"bar")); //returns true;

// logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3,"foo")); //returns false;

// logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8,"bar")); //returns false;

// logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10,"foo")); //returns false;

// logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11,"foo")); //returns true;
    }





}
