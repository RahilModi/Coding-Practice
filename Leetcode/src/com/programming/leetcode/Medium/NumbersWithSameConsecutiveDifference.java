package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifference {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> res = new ArrayList<>();
        int start = N == 1 ? 0 : 1;
        for(int i = start; i <= 9; i++){
            backtrack(N, K, 0, i, i, res);
        }
        return  res.stream().mapToInt(i->i).toArray();
    }

    private void backtrack(int N, int K, int idx,int crtVal,  int prev, List<Integer> res){
        if(idx == N-1){
            res.add(crtVal);
            return;
        }
        if(prev + K < 10){
            backtrack(N,K,idx+1, ( crtVal*10 )+ prev+K , prev+K, res) ;
        }
        if(prev + K != prev - K && (prev - K >=0)){
            backtrack(N,K,idx+1, ( crtVal*10 )+ prev-K , prev-K, res) ;
        }
    }

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifference obj = new NumbersWithSameConsecutiveDifference();
        System.out.println(Arrays.toString(obj.numsSameConsecDiff(3, 7)));
    }
}
