package com.programming.leetcode.Medium;

public class SoupServing {

    private final int[] serveA = {100,75,50,25};
    private final int[] serveB = {0,25,50,75};
    private double[][] memo;
    public double soupServings(int N) {
        if(N > 5000) return 1.0;
        memo = new double[N+1][N+1];
        return helper(N,N);
    }

    private double helper(int A, int B){
        if(A <= 0 && B <= 0) return 0.5;
        if(A <= 0) return 1.0;
        if(B <= 0) return 0.0;

        if(memo[A][B] > 0) return memo[A][B];
        for(int i =0; i < 4; i++){
            memo[A][B] += helper(A-serveA[i], B-serveB[i]);
        }
        return memo[A][B]*=0.25; //because 4 serving options so probability of one serving is 0.25
    }

    public static void main(String[] args) {
        SoupServing obj = new SoupServing();
        System.out.println(obj.soupServings(50));
    }

}
