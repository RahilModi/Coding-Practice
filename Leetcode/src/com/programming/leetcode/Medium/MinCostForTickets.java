package com.programming.leetcode.Medium;

public class MinCostForTickets {

    class Day{
        boolean isInPlan = false;
        int cost = 0;
    }

    public int mincostTickets(int[] days, int[] costs) {
        if(days == null||days.length == 0) return 0;
        int tripEnds = days[days.length-1];
        Day[] dp = new Day[366];
        for(int i = 0; i < 366; i++){
            dp[i] = new Day();
        }
        for(int d : days){
            dp[d].isInPlan = true;
        }
        dp[0].cost = 0;
        for(int i = 1; i <= 365 && i <= tripEnds; i++){
            if(!dp[i].isInPlan){
                dp[i].cost = dp[i-1].cost;
                continue;
            }
            dp[i].cost = Math.min(dp[i-1].cost+costs[0], Math.min(dp[Math.max(0, i-7)].cost + costs[1], dp[Math.max(0, i-30)].cost + costs[2]));
        }
        return dp[tripEnds].cost;
    }
}
