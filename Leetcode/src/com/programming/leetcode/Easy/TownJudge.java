package com.programming.leetcode.Easy;

/*
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 */
public class TownJudge {

    public int findJudge(int N, int[][] trust) {
        if(trust.length == 0 && N == 1) return 1;
        int[] indegrees = new int[N];
        boolean[] outdegrees = new boolean[N];
        for(int[] t : trust){
            indegrees[t[1]-1]++;
            outdegrees[t[0]-1] = true;
        }

        for(int  i = 0; i < N; i++){
            if(outdegrees[i]) continue;
            if(indegrees[i] == N-1) return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        TownJudge obj = new TownJudge();
        System.out.println(obj.findJudge(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }
}
