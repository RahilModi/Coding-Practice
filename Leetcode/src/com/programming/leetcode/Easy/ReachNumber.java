package com.programming.leetcode.Easy;

public class ReachNumber {

    //https://leetcode.com/problems/reach-a-number/discuss/112968/Short-JAVA-Solution-with-Explanation
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0, sum = 0;
        while(sum < target){
            sum += ++step;
        }
        //If we reach at the pos where sum is greater than target to comeback we need a difference which should be 2*i for ith iteration.
        while((sum - target) % 2 !=0){
            sum += ++step;
        }
        return step;
    }

    public static void main(String[] args) {
        ReachNumber obj = new ReachNumber();
        System.out.println(obj.reachNumber(3));
    }
}
