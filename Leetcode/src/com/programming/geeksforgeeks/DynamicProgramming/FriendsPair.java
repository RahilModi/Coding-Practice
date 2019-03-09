package com.programming.geeksforgeeks.DynamicProgramming;

//https://www.geeksforgeeks.org/friends-pairing-problem/
public class FriendsPair {

    public int numWaysFriendsPaired(int n){
        if(n <= 2) return n;
        return numWaysFriendsPaired(n-1) + (n-1) * numWaysFriendsPaired(n-2);
    }

    public int numWaysFriendsPairedDP(int n){
        int[]dp = new int[n+1];
        for(int i = 0; i <= n ; i++){
            if(i <= 2) dp[i] = i;
            else{
                dp[i] = dp[i-1] + (i-1)*dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FriendsPair obj = new FriendsPair();
        System.out.println(obj.numWaysFriendsPaired(4));
        System.out.println(obj.numWaysFriendsPairedDP(4));
    }
}
