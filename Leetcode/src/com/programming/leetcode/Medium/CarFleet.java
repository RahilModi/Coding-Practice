package com.programming.leetcode.Medium;

import java.util.Map;
import java.util.TreeMap;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> map = new TreeMap<>();
        for(int i = 0; i < position.length; i++){
            map.put(target-position[i],(double)(target - position[i])/speed[i]);
        }
        int res = 0;
        double crt = 0;
        for(double time : map.values()){
            if(time > crt){
                crt = time;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CarFleet obj = new CarFleet();
        System.out.println(obj.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
    }
}
