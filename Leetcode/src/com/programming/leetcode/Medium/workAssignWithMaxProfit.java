package com.programming.leetcode.Medium;

import javafx.util.Pair;

import java.awt.Point;
import java.util.*;

public class workAssignWithMaxProfit {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        Point[] combination = new Point[difficulty.length];
        for(int i =0 ; i < difficulty.length; i++){
            combination[i] = new Point(difficulty[i], profit[i]);
        }

        Arrays.sort(combination, (a,b) -> a.x - b.x);
        Arrays.sort(worker);
        int result = 0, crt_best = 0, i = 0;
        for(int skill : worker){
            while(i < combination.length && skill >= combination[i].x){
                crt_best = Math.max(crt_best, combination[i].y);
                i++;
            }
            result += crt_best;
        }
        return result;
    }

    public int maxProfitAssignmentV2(int[] difficulty, int[] profit, int[] worker) {

        List<Pair<Integer,Integer>> jobs = new ArrayList<>();

        for(int i =0 ; i < difficulty.length; i++){
            jobs.add(new Pair<>(difficulty[i], profit[i]));
        }

        Collections.sort(jobs, Comparator.comparing(Pair::getKey));

        Arrays.sort(worker);
        int result = 0,i=0,crt_best = 0;
        for(int ability : worker){
            while(i < jobs.size() && ability >= jobs.get(i).getKey()){
                crt_best = Math.max(crt_best, jobs.get(i).getValue());
                i++;
            }
            result += crt_best;
        }
        return result;
    }


}
