package com.programming.leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class NumUniqueBSTs {

    /**
     * Taking 1~n as root respectively:
     *      1 as root: # of trees = F(0) * F(n-1)  // F(0) == 1
     *      2 as root: # of trees = F(1) * F(n-2)
     *      3 as root: # of trees = F(2) * F(n-3)
     *      ...
     *      n-1 as root: # of trees = F(n-2) * F(1)
     *      n as root:   # of trees = F(n-1) * F(0)
     *
     * So, the formulation is:
     *      F(n) = F(0) * F(n-1) + F(1) * F(n-2) + F(2) * F(n-3) + ... + F(n-2) * F(1) + F(n-1) * F(0)
     */

    public int numTrees(int n) {

        int dp[] = new int[ n + 1];

        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n ; i++){
            for(int j = 1; j <= i ; j++) {
                dp[i] += dp[j-1] * dp[i-j];  //G[n] = G[0]*G[n-1] + G[1] * G[n-2] + .... + G[n-1]*G[0];
            }
        }
        return dp[n];
    }


    public int numTreesV2(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        map.put(1,1);
        return numTrees(n, map);
    }

    private int numTrees(int n, Map<Integer, Integer> map){
        // check memory
        if(map.containsKey(n)) return map.get(n);
        // recursion
        int sum = 0;
        for(int i = 1;i <= n;i++)
            sum += numTrees(i-1, map) * numTrees(n-i, map);
        map.put(n, sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new NumUniqueBSTs().numTrees(3));
    }

}
