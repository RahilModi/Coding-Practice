package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {

    public int numRabbits(int[] answers) {
        if(answers == null || answers.length == 0) return 0;
        if(answers.length == 1) return answers[0]+1;

        Map<Integer, Integer> map = new HashMap<>();
        int numUniques = 0;
        for(int n : answers) {
            if(n == 0) numUniques++;
            else
                map.put(n, map.getOrDefault(n, 0)+1);
        }
        int minPos = numUniques;
        for(int k : map.keySet()){
            int numSameColor = k+1;
            int val = map.get(k);
            minPos += (numSameColor) * (val/ (numSameColor) + ( val % (numSameColor) == 0 ? 0 : 1));
        }
        return minPos;
    }

    public int numRabbitsV1(int[] answers) {
        int c[] = new int[1000], res = 0;
        for (int i : answers)
            if (c[i]++ % (i + 1) == 0)
                res += i + 1;
        return res;
    }

    public static void main(String[] args) {
        RabbitsInForest obj = new RabbitsInForest();
        System.out.println(obj.numRabbitsV1(new int[]{0,0,1,1,1}));
        System.out.println(obj.numRabbits(new int[]{10,10,10}));
        System.out.println(obj.numRabbits(new int[]{1,1,2}));
    }



}
