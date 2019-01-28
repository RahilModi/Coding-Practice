package com.programming.leetcode.Easy;

//MUST READ ALGORITHM  EXPLANATION: https://leetcode.com/problems/poor-pigs/discuss/94266/Another-explanation-and-solution
public class PoorPigs {

    //Using 2 pigs we can solve 25 buckets if test at 60 min and dies within 15 min.
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        //int states = minutesToTest/minutesToDie + 1;
        //System.out.println(Math.ceil(Math.log(buckets)/Math.log(states)));
        int num_pigs = 0;
        while(Math.pow((minutesToTest/minutesToDie+1),num_pigs) < buckets){
            num_pigs +=1;
        }
        return num_pigs;
    }

    public static void main(String[] args) {
        PoorPigs obj = new PoorPigs();
        obj.poorPigs(1000,15,60);
    }
}
