package com.programming.leetcode.Hard;

public class PaintHouseII {

    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;

        int n = costs.length, k = costs[0].length;
        if(k == 1) return (n==1? costs[0][0] : -1);

        int prevMinId = -1, prevMin = 0, prevSecMin = 0;
        int val = 0;
        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE, minId = -1, secMin = Integer.MAX_VALUE;
            for(int j = 0; j < k; j++){
                val = costs[i][j] + (j == prevMinId ? prevSecMin : prevMin);
                if(minId < 0) {
                    minId = j;
                    min = val;
                }
                else if(val < min){
                    secMin = min;
                    min = val;
                    minId = j;
                }else if(secMin > val) {
                    secMin = val;
                }
            }
            prevMin = min;
            prevMinId = minId;
            prevSecMin = secMin;
        }

        return prevMin;

    }


}
