package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TicketReseller {


    public int maxProfit(int[] sellers, int num_buyers){
        PriorityQueue<Integer> sortedByTicketPrice = new PriorityQueue<>((a,b)->b-a);
        for(int i = 0; i < sellers.length; i++){
            for(int j = 1; j <= sellers[i]; j++){
                sortedByTicketPrice.offer(j);
            }
        }
        int maxProfit = 0;
        while(num_buyers != 0){
            maxProfit += sortedByTicketPrice.poll();
            num_buyers--;
        }

        return maxProfit;


    }

    public int[] maxSwapToMakeNoPairs(String[] input){

        int[] res = new int[input.length];
        int index = 0;
        for(String str : input){
            if(str.length() > 1) {
                int j;
                for (int i = 0; i < str.length();) {
                    j = i + 1;
                    while (j < str.length() && str.charAt(j) == str.charAt(i)) {
                        j++;
                    }
                    res[index] += (j - i) / 2;
                    i=j;
                }
            }
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println( new TicketReseller().maxProfit(new int[]{3,5},6) );
        for(int i : new TicketReseller().maxSwapToMakeNoPairs(new String[]{"ab","abb","aab","abab","abaaaab"})){
            System.out.println(i);
        }
    }
}
